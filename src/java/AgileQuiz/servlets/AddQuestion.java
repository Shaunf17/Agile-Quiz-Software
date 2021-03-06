 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgileQuiz.servlets;

import AgileQuiz.stores.LoggedIn;
import Models.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brodieross
 */
@WebServlet(name = "AddQuestion", urlPatterns = {"/AddQuestion"})
public class AddQuestion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddQuestion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddQuestion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
       
        int question_num = Integer.parseInt(request.getParameter("question_number"));
        String question = request.getParameter("question_asked");
        String correct_answer = request.getParameter("correct_answer");
        String answer2 = request.getParameter("answer_two");
        String answer3 = request.getParameter("answer_three");
        String answer4 = request.getParameter("answer_four");
         
        
        
        
        Quiz quiz = new Quiz();
        LoggedIn lg = (LoggedIn) request.getSession().getAttribute("LoggedIn");
        int staff_id = lg.getStaffID();
        String quiz_name= lg.getQuizName();
        // need to implement storage of current quiz and staff id as session variables
        
        
        int quizid= quiz.GetQuizID(quiz_name, staff_id);
        quiz.NewQuestion(quizid, question_num, question);
        
        
        int questionid = quiz.getQuestionID(quizid, question);
        quiz.newAnswer(questionid, correct_answer , 1);
        quiz.newAnswer(questionid, answer2 , 0);
        quiz.newAnswer(questionid, answer3  , 0);
        quiz.newAnswer(questionid, answer4  , 0);
      
        response.sendRedirect("/AgileQuizSoftware/addQuestion.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
