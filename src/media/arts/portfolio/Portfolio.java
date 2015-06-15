import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

public class Portfolio extends PApplet{
    GButton btnexit, btngallery, btnhome, btnnxtpage, btnprevpage, btnquiz, btnsubmit;
    GButton gallerybtns[][] = new GButton[3][4];
    String question[] = {"What is the name of the first assignment?", "What program did I use for my vector art?", "What page is the Surrealism art on?", "What were my fruit sculptures made of?"};
    String falsesnwers[] = {"Surrealism", "Movie Poster", "Adobe Photoshop","Blender", "Page 6", "Page 10", "Tin Foil", "Paper"};
    String answers[] = {"Environment Tutorial", "Adobe Illustrator", "Page 8", "Tape"};
    String result="";
    GTextArea gtarea, gtarea2;
    GLabel lblpage;
    GOption choi1, choi2, choi3;
    GToggleGroup choices;
    String pages;
    PImage mainBG, artwork, artwork2;
    int count=60,pagenum=1, xloc=200, yloc=120, page=2, temp, score=0, quest=0, x=0,y=0,z=1, countDet=0;
    GTimer gt;
	public void setup(){
		size(840, 680, JAVA2D);
                btnexit = new GButton(this, 700, 20, 100, 30);
                btnexit.setText("Exit");
                btnnxtpage = new GButton(this, 580, 20, 100, 30);
                btnnxtpage.setText("Next Page");
                btnhome = new GButton(this, 20, 20, 100, 30);
                btnhome.setText("Home");
                btngallery = new GButton(this, 140, 20, 100, 30);
                btnprevpage = new GButton(this, 460, 20, 100, 30);
                btnprevpage.setText("Previous Page");
                btnprevpage.setVisible(false);
                btngallery.setText("Gallery");
                mainBG = loadImage("portfolioBG.jpg");
                btnhome.setVisible(false);
                gt = new GTimer(this,this, "countDown", 1000);
                lblpage = new GLabel(this, 820, 630, 40, 20);
                gtarea = new GTextArea(this, 30, 505, 600, 160);
                gtarea2 = new GTextArea(this, 405, 75, 340, 390);
                gtarea.setVisible(false);
                gtarea2.setVisible(false);
                
                btnquiz = new GButton(this,300, 20, 100, 30);
                btnquiz.setText("Start Quiz");
                btnquiz.setVisible(false);
                
                choi1 = new GOption(this, 40, 100, 200, 30);
                choi2 = new GOption(this, 40, 130, 200, 30);
                choi3 = new GOption(this, 40, 160, 200, 30);
                
                btnsubmit = new GButton(this, 50, 300, 100, 30);
                btnsubmit.setVisible(false);
                btnsubmit.setText("Submit");
                
                
                choi1.setText(falsesnwers[x]);
                choi2.setText(answers[y]);
                choi3.setText(falsesnwers[z]);
                choi1.setVisible(false);
                choi2.setVisible(false);
                choi3.setVisible(false);
                
                
                choices = new GToggleGroup();
                choices.addControl(choi1);
                choices.addControl(choi2);
                choices.addControl(choi3);
	}

	public void handleButtonEvents(GButton button, GEvent event){
            for(int x=0; x<3; x++){
                for(int y=0; y<4;y++){
                    if(button==gallerybtns[x][y]){
                        pages = gallerybtns[x][y].getText();
                        pages = pages.substring(5);
                        temp = Integer.parseInt(pages);
                        pagenum=temp;
                        btnhome.setVisible(true);
                        btnprevpage.setVisible(true);
                        gtarea.setVisible(true);
                        gtarea2.setVisible(true);
                        for(int i=0; i<3; i++){
                            for(int j=0; j<4;j++){
                                gallerybtns[i][j].setVisible(false);
                                page=2;
                            }
                        }
                    }   
                }
            }
            
            
            if(button==btnsubmit){
                if(countDet==3){
                    pagenum=1;
                    btngallery.setVisible(true);
                    btnhome.setVisible(true);
                    gtarea.setVisible(false);
                    gtarea2.setVisible(false);
                    btnnxtpage.setVisible(true);
                    btnprevpage.setVisible(true);
                    btnquiz.setVisible(false);
                    btnsubmit.setVisible(false);
                    choi1.setVisible(false);
                    choi2.setVisible(false);
                    choi3.setVisible(false);
                    btnquiz.setText("Quiz Done");
                    question[3]="";
                    result = "You got: "+(score+1)+" out of 4!";
                }
                quest+=1;
                if(choi1.isSelected()){
                    score+=0;
                }
                else if(choi2.isSelected()){
                    score+=1;
                }
                else{
                    score+=0;
                }
                choi1.setText(falsesnwers[(x+2)]);
                choi2.setText(answers[(y+1)]);
                choi3.setText(falsesnwers[(z+2)]);
                x+=2;
                y+=1;
                z+=2;
                countDet+=1;
                
            }
                
            if(button==btnquiz){
                btngallery.setVisible(false);
                btnhome.setVisible(false);
                btnnxtpage.setVisible(false);
                btnprevpage.setVisible(false);
                btnquiz.setEnabled(false);
                gtarea.setVisible(false);
                gtarea2.setVisible(false);
                btnsubmit.setVisible(true);
                pagenum=20;
                choi1.setVisible(true);
                choi2.setVisible(true);
                choi3.setVisible(true);
                
            }
            
            
            if(button==btngallery){
                result="";
                yloc=200;
                btnhome.setVisible(true);
                gtarea.setVisible(false);
                gtarea2.setVisible(false);
                pagenum=18;
                for(int x=0; x<3;x++){
                    for(int y=0; y<4;y++){
                        gallerybtns[x][y] = new GButton(this,xloc,yloc,100,30);
                        gallerybtns[x][y].setText("Page "+page);
                        page+=1;
                        xloc+=120;
                    }
                    xloc=200;
                    yloc+=50;
                }
            }
            else if(button==btnnxtpage){
                result="";
                btnhome.setVisible(true);
                btnprevpage.setVisible(true);
                gtarea.setVisible(true);
                gtarea2.setVisible(true);
                if(pagenum==18){
                for(int x=0; x<3;x++){
                    for(int y=0; y<4;y++){
                        gallerybtns[x][y].setVisible(false);
                        page=2;
                    }
                }
                    pagenum=2;
                }
                else if(pagenum>=13)JOptionPane.showMessageDialog(this, "This is last page of my assignments");
                else pagenum+=1;

                
                
            }
            else if(button==btnhome){
                result="";
                gtarea.setVisible(false);
                gtarea2.setVisible(false);
                for(int x=0; x<3;x++){
                    for(int y=0; y<4;y++){
                        gallerybtns[x][y].setVisible(false);
                        page=2;
                    }
                }
                btnprevpage.setVisible(false);
                btnhome.setVisible(false);
                pagenum=1;
                
            }
            else if(button==btnprevpage){
                result="";
                gtarea.setVisible(true);
                gtarea2.setVisible(true);
                for(int x=0; x<3;x++){
                    for(int y=0; y<4;y++){
                        gallerybtns[x][y].setVisible(false);
                        page=2;
                    }
                }
                if(pagenum<=2)JOptionPane.showMessageDialog(this, "This is first page");
                else pagenum-=1;
            }
            else if(button==btnexit)System.exit(0);
            
            
            
            if(pagenum==1){
                artwork = loadImage("");
            }
            else if(pagenum==2){
                artwork = loadImage("enviroTutorial.jpg");
            }
            else if(pagenum==3){
                artwork = loadImage("enviroArt.jpg");
            }
            else if(pagenum==4){
                artwork = loadImage("old to new.jpg");
            }
            else if(pagenum==5){
                artwork = loadImage("postertutorial.jpg");
            }
            else if(pagenum==6){
                artwork = loadImage("MoviePoster.jpg");
            }
            else if(pagenum==7){
                artwork = loadImage("ComeToNewYork.jpg");
            }
            else if(pagenum==8){
                artwork = loadImage("Surrealism Art.jpg");
            }
            else if(pagenum==9){
                artwork = loadImage("IMG_2650.JPG");
                artwork2 = loadImage("IMG_2656.JPG");
            }
            else if(pagenum==10){
                artwork = loadImage("yearbookentry.jpg");
            }
            else if(pagenum==11){
                artwork = loadImage("soundart.jpg");
            }
            else if(pagenum==12){
                artwork = loadImage("Transformation.jpg");
            }
            else if(pagenum==13){
                artwork = loadImage("goldsworthy.jpg");
                btnquiz.setVisible(true);
            }
            else if(pagenum==18){
                artwork = loadImage("");
            }
            else{
                artwork = loadImage("");
            }
            
            
            
            
		
	}
        public void countDown(GTimer t){
            count--;
            
        }
	public void draw(){
		background(mainBG); 
                fill(255);
                textFont(createFont("Arial",15));
                text("Page "+pagenum,780,655);
                text(result, 60,200);
                if(artwork!=null){
                    fill(200,10,10);
                    
                    if(pagenum==5 || pagenum==6 || pagenum==10 || pagenum==12){
                        image(artwork,40,60);
                        rect(400, 70, 350, 400);
                        gtarea.setVisible(false);
                    }
                    else if(pagenum==9){
                        image(artwork,100,80);
                        image(artwork2,430,80);
                        rect(25, 500, 610, 170);
                        gtarea2.setVisible(false);
                    }
                    else{
                        image(artwork,140,80);
                        rect(25, 500, 610, 170);
                        gtarea2.setVisible(false);
                    }
                }
                
                if(pagenum==20){
                    fill(255);
                    textFont(createFont("Arial",25));
                    if(quest==0){
                        text(question[0],40,80);
                    }
                    else if(quest==1){
                        text(question[1],40,80);
                    }
                    else if(quest==2){
                        text(question[2],40,80);
                    }
                    else{
                        text(question[3],40,80);
                    }
                    
                }
                
	}
        
        //created my own way of hiding buttons
        class settingVisButtons{
            boolean setVisible(boolean h){
                if(h==true){
                    btnhome = new GButton(null, 1000, 20, 100, 30);
                    btnprevpage = new GButton(null, 1000, 20, 100, 30);
                    btnnxtpage = new GButton(null, 1000, 20, 100, 30);
                    btngallery = new GButton(null, 1000, 20, 100, 30);
                    choi1 = new GOption(null, 1000, 100, 100, 30);
                    choi2 = new GOption(null, 1000, 130, 100, 30);
                    choi3 = new GOption(null, 1000, 160, 100, 30);
                    btnsubmit = new GButton(null, 1000, 300, 100, 30);
                    btnquiz = new GButton(null,1000, 20, 100, 30);
                    gtarea = new GTextArea(null, 1000, 500, 600, 160);
                    gtarea2 = new GTextArea(null, 1000, 75, 340, 390);
                }
                else{
                    btnhome = new GButton(null, 20, 20, 100, 30);
                    btnprevpage = new GButton(null, 460, 20, 100, 30);
                    btnnxtpage = new GButton(null, 580, 20, 100, 30);
                    btngallery = new GButton(null, 140, 20, 100, 30);
                    choi1 = new GOption(null, 40, 100, 100, 30);
                    choi2 = new GOption(null, 40, 130, 100, 30);
                    choi3 = new GOption(null, 40, 160, 100, 30);
                    btnsubmit = new GButton(null, 50, 300, 100, 30);
                    btnquiz = new GButton(null,300, 20, 100, 30);
                    gtarea = new GTextArea(null, 30, 500, 600, 160);
                    gtarea2 = new GTextArea(null, 405, 75, 340, 390);
                }
                return true;
            }
        }
}