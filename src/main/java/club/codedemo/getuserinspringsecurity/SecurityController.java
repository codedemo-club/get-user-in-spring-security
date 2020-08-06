package club.codedemo.getuserinspringsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class SecurityController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @RequestMapping(value = "/username1", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName1(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        logger.info("User当前拥有的角色信息为 " + userDetails.getAuthorities());

        return authentication.getName();
    }

    @RequestMapping(value = "/username2", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName2(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    @RequestMapping(value = "/username3", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName3() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "/username4", method = RequestMethod.GET)
    public String currentUserName4() {
        return "username4";
    }
}
