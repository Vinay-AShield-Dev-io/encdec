package com.ashield.encdec.stdencdec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

// import com.ashield.AShieldEncDec.AShieldEncDec;
@Controller
public class EncDecController {
    @Autowired
    AShieldEncDec mAshieldEncObj;

    @RequestMapping(value = "/encrypt")
    public @ResponseBody String encryptMessage(
            @RequestParam(value = "text") String txt) {
        try {
            String msg = "";
            msg = mAshieldEncObj.encrypt(txt);
            return msg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Server error";
        }

    }
    @RequestMapping(value = "/decrypt")
    public @ResponseBody String decryptMessage(
            @RequestParam(value = "text") String txt) {
        try {
            String msg = "";
            msg = mAshieldEncObj.decrypt(txt);
            return msg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Server error";
        }

    }

}