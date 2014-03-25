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
public class Mathematician extends Student{
    String[] answers = {"Hi", "I'm fine", "11", "Of course, it's a simple integration", "I suppose you mean Conway's Game of life",
        "0.698131701", "The definition of the problem is not correct.\nBut if another one would enter the tonnel there would be none of them",
        "Thank you."};
    
    
    public Mathematician(String name) throws IOException {
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
