import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

public class Portfolio extends PApplet{
    static GButton btnexit, btngallery, btnhome, btnnxtpage, btnprevpage;
    GLabel lblpage;
    PImage mainBG, artwork, artwork2;
    int count=60,pagenum=1;
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
                

	}

	public void handleButtonEvents(GButton button, GEvent event){
            if(button==btngallery){
                btnhome.setVisible(true);
                pagenum=14;
                
            }
            else if(button==btnnxtpage){
                
                btnhome.setVisible(true);
                btnprevpage.setVisible(true);
                if(pagenum==14)pagenum=2;
                else if(pagenum>=13)JOptionPane.showMessageDialog(this, "This is last page of my assignments");
                else pagenum+=1;
                
            }
            else if(button==btnhome){
                btnhome.setVisible(false);
                pagenum=1;
                
            }
            else if(button==btnprevpage){
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
            }
            else if(pagenum==14){
                artwork = loadImage("");
            }
		
	}
        public void countDown(GTimer t){
            count--;
            
        }
	public void draw(){
		background(mainBG); 
                fill(255);
                text("Page "+pagenum,785,655);
                if(artwork!=null){
                    if(pagenum==5 || pagenum==6 || pagenum==10 || pagenum==12)image(artwork,40,100);
                    else if(pagenum==9){
                        image(artwork,100,100);
                        image(artwork2,430,100);
                    }
                    else image(artwork,140,100);
                }
                
	}
        //created my own way of hiding buttons
        class settingVisButtons{
            boolean setVisible(boolean h){
                if(h==true){
                    btnhome = new GButton(null, 1000, 20, 100, 30);
                    btnprevpage = new GButton(null, 1000, 20, 100, 30);
                }
                else{
                    btnhome = new GButton(null, 20, 20, 100, 30);
                    btnprevpage = new GButton(null, 460, 20, 100, 30);
                }
                return true;
            }
        }
}