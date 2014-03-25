/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testwai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Walter
 */
public abstract class Student {
    private Engine engine;
    private String name;
    private String[] answers;
    private String specialization;
    private static LinkedList<String> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    abstract public boolean wai(String classification);
    
    public Student(String name){
        this.name = name;
        list = new LinkedList<>();
        randPhrases();
    }
    
    public Student(String name, String[] answers){
        this.name = name; 
        this.answers = answers;
        list = new LinkedList<>();
        randPhrases();
    }
    
    static class Engine{
        final private String filename = "C:\\Users\\user\\Documents\\NetBeansProjects\\TestWAI\\src\\testwai\\INPUT";
        private LinkedList<String> questions;
        private String question;
        
        
        public Engine() throws FileNotFoundException, IOException{
            questions = new LinkedList();
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String buffer;
            while((buffer = reader.readLine()) != null){
                questions.add(buffer + '\n');
            }
        }
        
        
        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public LinkedList<String> getQuestions() {
            return questions;
        }

        public void setQuestions(LinkedList<String> answers) {
            this.questions = answers;
        }
    }
    
    public boolean isMisunderstanding(String input){
        return input.contains("?");
    }
    
    public void adder(){
        for(int i = 0; i < answers.length; ++i){
            if(isMisunderstanding(answers[i]) && (i + 1) < answers.length - 1){
                Collections.shuffle(list); 
                this.getEngine().getQuestions().set(i + 1, (list.get(0) + this.getEngine().getQuestions().get(i + 1)));
            }
        }
    }
    
    private void randPhrases(){
        list.add("Nothing. Next question. ");
        list.add("Forget it. Next one. ");
        list.add("I see. Let us go to next point. ");
        list.add("Ok. It would be better for us to procced questioning. ");
        list.add("Yeah, I see. Next point. ");
    }
}
