import com.google.gson.Gson;
import myServlet.ss.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet({"/Login","/login/","/Login/"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
 
    }

	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		String path = req.getRequestURI().substring(req.getContentLength());
		
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		output.print("<html><body>HELLO</body></html>");
//		output.flush();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		doGet(request,response);
		String loginFail = "<html><body> FAIL </body></html>";
		String loginSuccess = "<html><body> SUCCESS </body></html>";
		User myUser = new User("Sinatraa","root");
		
		
		User user = gson.fromJson(request.getReader(), User.class);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isExistingUser = myUser.getUserName().equals(user.getUserName());
		boolean userPWord = myUser.getPassword().equals(user.getPassword());
		out.print((isExistingUser && userPWord) ? loginSuccess : loginFail);
		out.flush();
	}

}
