

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("in 2 ");
		String name_p=request.getParameter("name_p");
		String age_s=request.getParameter("age_p");
		String gender_p=request.getParameter("gender_p");
		String fav_dir=request.getParameter("fav_dir");
		String fav_mov=request.getParameter("fav_mov");
		String req = request.getParameter("Req");
		int age=Integer.parseInt(age_s);
		System.out.println(name_p+" "+age+" "+gender_p+" "+fav_dir+" "+fav_mov);
		Member m=new Member(name_p,age,gender_p,fav_dir,fav_mov);
		RegisterDao rd=new RegisterDao();
		String res=rd.Insert(m,req);
		rd.Statistics(fav_dir,fav_mov);
		int arr[]=rd.Rank_Dir();
		PrintWriter out= response.getWriter();
		out.println(" <br> <u align-items:center><b>Directors Rankings</b></u><br>");
		out.println(" <br>Manu Ashokan  with "+ arr[0]+"% votes");
		out.println(" <br>Mari Selvaraj with "+ arr[1]+"% votes");
		out.println(" <br>Meghna Gulzar with "+ arr[2]+"% votes");
		out.println(" <br>Prasanth Varma with "+ arr[3]+"% votes");
		out.println(" <br>Raghu Samarth with "+ arr[4]+"% votes");
		out.println(" <br>Sudha Kongara Prasad with "+ arr[5]+"% votes");
		int arr2[]=rd.Rank_Mov();	
		out.println(" <br><br> <u><b>Movies Rankings</b></u><br>");
		out.println(" <br>Pariyerum Perumal  with "+ arr2[0]+"% votes");
		out.println(" <br>Uyare with "+ arr2[1]+"% votes");
		out.println(" <br>Awe with "+ arr2[2]+"% votes");
		out.println(" <br>Law with "+ arr2[3]+"% votes");
		out.println(" <br>Raazi with "+ arr2[4]+"% votes");
		out.println(" <br>Soorarai Potru with "+ arr2[5]+"% votes");
		
	}

}
