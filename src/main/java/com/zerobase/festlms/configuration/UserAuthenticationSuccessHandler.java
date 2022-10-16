package com.zerobase.festlms.configuration;

import com.zerobase.festlms.member.entity.Member;
import com.zerobase.festlms.member.entity.MemberHistory;
import com.zerobase.festlms.member.repository.HistoryMemberRepository;
import com.zerobase.festlms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final MemberRepository memberRepository;
    private final HistoryMemberRepository historyRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String userId = authentication.getName();
        Optional<Member> optionalMember = memberRepository.findById(userId);
        Member member = optionalMember.get();
        member.setLastLoginDt(LocalDateTime.now());
        memberRepository.save(member);

        String userAgent = request.getHeader("User-Agent");
        String clientIp = request.getHeader("X_FORWARDED-FOR");
        if(clientIp == null || clientIp.length() == 0) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if(clientIp == null || clientIp.length() == 0) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if(clientIp == null || clientIp.length() == 0) {
            clientIp = request.getRemoteAddr();
        }

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setUserIp(clientIp);
        memberHistory.setUserId(userId);
        memberHistory.setUserAgent(userAgent);
        memberHistory.setLoginDt(LocalDateTime.now());
        historyRepository.save(memberHistory);


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
