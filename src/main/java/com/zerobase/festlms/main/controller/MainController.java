package com.zerobase.festlms.main.controller;

// MainPage 클래스를 만든 목적
// 매핑하기 위해서...
// 주소와(논리적인주소인터넷주소) 물리적인파일(프로그래밍을 해야 하니까) 매핑

// 하나의 주소에 대해서
// 어디서 매핑? 누가 매핑?
// 후보군? 클래스, 속성, 메소드
// 메소드가 매핑
import com.zerobase.festlms.admin.banner.service.BannerService;
import com.zerobase.festlms.admin.banner.dto.BannerDto;
import com.zerobase.festlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    private final BannerService bannerService;
    //아래 처럼 노가다하는걸 쉽게 하기위해
    //thymleaf 사용
    @RequestMapping("/")
    public String index(Model model) {
        List<BannerDto> bannerDtoList = bannerService.frontList();
        model.addAttribute("list",bannerDtoList);
        return "index";
    }
    
    // request -> WEB에서 서버로 데이터를 보내는 객체
    // response -> 서버에서 웹으로 데이터를 보내는 객체
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "</head>" +
                "<body>" +
                "<p>hello</p> <p>fastlms website!!!</p>" +
                "<p> 안녕하세요!!! </p>" +
                "</body>" +
                "</html>";
        printWriter.write(msg);
        printWriter.close();
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {
        return "error/denied";
    }
}
