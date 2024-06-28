package com.mail.controller;

import com.mail.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.Context;

@Controller
@RequestMapping("/test")
public class SendEmailController {

    private final EmailService emailService;

    public SendEmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/sendmail/{to}")
    public String testSendMail(@PathVariable String to) {
        emailService.sendEmail(to);
        return "success-sendmail";
    }
    
    @GetMapping("/sendmailWithTemplate/{to}")
    public String testSendMailTemplate(@PathVariable String to) {
        Context context = new Context();
        context.setVariable("message", "Hello World!");

        emailService.sendEmailWithHtmlTemplate("email-template.html", context, to);
        return "success-sendmail";
    }
}
