package in.mindcraft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {
	
	@RequestMapping("/")
	public void add(HttpServletRequest request,HttpServletResponse response) {
 System.out.println("add called..");
	}
}
