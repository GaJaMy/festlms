package com.zerobase.festlms.member.service;

import com.zerobase.festlms.admin.dto.MemberDto;
import com.zerobase.festlms.admin.model.MemberParam;
import com.zerobase.festlms.course.model.ServiceResult;
import com.zerobase.festlms.member.model.MemberInput;
import com.zerobase.festlms.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {
    boolean register(MemberInput parameter);
    boolean emailAuth(String uuid);
    boolean sendResetPassword(ResetPasswordInput parameter);
    boolean resetPassword(String uuid,String password);
    boolean checkResetPassword(String uuid);

    List<MemberDto> list(MemberParam parameter);

    MemberDto detail(String userId);

    boolean updateStatus(String userId,String userStatus);

    boolean updatePassword(String userId, String password);

    ServiceResult updateMember(MemberInput parameter);

    ServiceResult updateMemberPassword(MemberInput parameter);

    ServiceResult withdraw(String userId, String password);
}
