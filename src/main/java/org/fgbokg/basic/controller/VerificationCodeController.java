package org.fgbokg.basic.controller;

import org.fgbokg.basic.service.IVerificationService;
import org.fgbokg.basic.util.AjaxResult;
import org.fgbokg.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码的controller
 */
@RestController
@RequestMapping("/verification")
public class VerificationCodeController {

    @Autowired
    private IVerificationService verificationService;

    @PostMapping("/sendMobileCode")
    public AjaxResult sendMobileCode(@RequestBody User user) {
        try {
            verificationService.sendMobileCode(user.getPhone());
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg(e.getMessage());
        }
    }
}
