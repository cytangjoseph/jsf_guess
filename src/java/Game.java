//unit 5, page 44
//project: number4
//author: cytangjoseph
// dynamic navigation

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Game implements Serializable {
    private int number;
    private Integer guess;
    private int trials;
    private String message;
    
    //getters and setters
    public Integer getGuess() {return guess;}
    public void setGuess(Integer guess){this.guess=guess;}
    
    public int getTrials(){return trials;}
    public void setTrials(int trials) {this.trials = trials;}
    
    public String getMessage(){return message;}
    public void setMessage(String msg){this.message = msg;}
    
    public String newGame(){
        number = (int)(Math.random()*100) + 1;
        guess = null;
        trials = 0;
        message = null;
        return "play";
    }
    public String doGuess(){
        trials++;
        if (guess > number) {
            message = "Your guess, " + guess +
                      ", is higher than my number";
            return null;// back to originating page
        } else if (guess < number) {
            message = "Your guess, " + guess +
                      ", is lower than my number";
            return null;
        } else {
            message = "Congratulations! Your guess," + guess +
                      ", is my number";
            return "success";//to success page
        
        }
    }
    
    @Override
    public String toString() {
        return "Game{" + "number=" + number + ", guess=" + guess
                + ", trials=" + trials + ", message" + message
                + '}';
        
    }
}
