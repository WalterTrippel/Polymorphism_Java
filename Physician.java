/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testwai;

import java.io.IOException;

/**
 *
 * @author Walter
 */
public class Physician extends Student{
    String[] answers = {"Hi", "I'm fine", "Excuse me?", "Sorry?", 
        "The mathematical interpretation of cell life cicle", "Equals to 60% of spirit plus 40% of liquid",
        "The have born the third one", "Not at all"};
    
    public Physician(String name) throws IOException {
        super(name);
        this.setEngine(new Student.Engine());
        this.setAnswers(this.answers);
    }

    @Override
    public String toString() {
        if(this.getEngine().getQuestions().toArray().length != this.answers.length){
            throw new ArrayIndexOutOfBoundsException("No correspondence between list of answers and list of questions! ");
        }
        this.adder();
        StringBuffer sb = new StringBuffer();
        sb.append(this.getName()).append('\n');
        for(int i = 0; i < this.getAnswers().length; ++i){
            String buffer = "M : " + this.getEngine().getQuestions().toArray()[i] + this.getName().toCharArray()[0] +" : " + this.answers[i] + "\n";
            sb.append(buffer);
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean wai(String classification) {
        return classification.equals(this.getClass().getSimpleName().toLowerCase());
    }
    
}
