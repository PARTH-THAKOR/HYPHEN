// Password Verification

package org.rorb.dev.hyphen.controllers;

import java.util.Objects;

public class Password {

    public static Boolean passWord(String password) {
        return password.length() == 17 && password.charAt(4) == 'p' && password.charAt(7) == 'a' && password.charAt(8) == 'r' && password.charAt(11) == 't' && password.charAt(15) == 'h' && password.charAt(16) == 'n';
    }

    public static Boolean passWordSuperDev(String userName, String password) {
        return Objects.equals(userName, "developers.hyphen") && Objects.equals(password, "prerna6938269");
    }
}
