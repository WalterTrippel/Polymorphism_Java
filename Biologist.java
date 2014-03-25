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
public class Biologist extends Student{
    String[] answers = {"Hello", "Everything is fine", "Sorry, what?", "Oh, I don't think so. Sorry", "The mathematical interpretation of cell life cicle",
        "Mendeleev's Liquer", "Possibility of evolution greeted",
        "Thank you."};
    
    
    public Biologist(String name) throws IOException {
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
