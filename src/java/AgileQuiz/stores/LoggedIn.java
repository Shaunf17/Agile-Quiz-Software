/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgileQuiz.stores;

/**
 *
 * @author gary-
 */
public class LoggedIn {
    boolean loggedIn = false;
    int matric =0;
    int staffid = 0;
    String quiz_name;
    
    
    public void LoggedIn(){
        
    }
    
    public void setQuizName(String quiz_name)
    {
        this.quiz_name=quiz_name;
    }
    
    public String getQuizName()
    {
    return quiz_name;    
    }
    
    public void setLoggedIn(){
        loggedIn=true;
    }
    public void setLoggedOut(){
        loggedIn=false;
    }
    
    public boolean getLoggedIn(){
        return loggedIn;
    }
    
    public int getStaffID()
    {
        return staffid;
    }
    public void setStaffID(int staffid)
    {
        this.staffid=staffid;
    }
    
    public int getMatric(){
        return matric;
    }
    public void setMatric(int name){
        this.matric=name;
    }
}
