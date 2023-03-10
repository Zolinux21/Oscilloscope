package application;

//import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Cursor;
//import javafx.scene.layout.BorderPane;
import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.shape.MoveTo;
//import javafx.scene.shape.Path;
//import javafx.scene.shape.QuadCurveTo;
//import javafx.stage.Stage;
//import javafx.scene.shape.QuadCurve; 
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
//import javafx.scene.shape.Polyline;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
import javafx.scene.paint.Color;  
//import javafx.scene.effect.BoxBlur;
import javafx.scene.shape.CubicCurve;
import javafx.scene.effect.Shadow;
import javafx.scene.input.KeyCode;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow; 
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class Main extends Application {
	// Steps
		public static int[] currentLevel = {6, 6, 6, 6, 6, 6, 6, 6}; // = 0
		static int currentVerticalLevel = 0;
		
		public static boolean gameEnable = false;
		 // PLC Variables
		static int counter = 0;
		 
		 // PLC variables
		static Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		 
		 //float screenResoultionX = (float)screenBounds.getMaxX();
		 //float screenResoultionY = (float)screenBounds.getMaxY();
		 
		static float screenResoultionX = 800;
		static float screenResoultionY = 600;
		 
		static float usedScreenX = (screenResoultionX / 100) * 90;
		 
		static float startPointX = 0.0f;
		static float startPointY = screenResoultionY / 2;
		static float endPointX = screenResoultionX;
		static float endPointY = startPointY;
		 
		static float countOfverticalLines = 16;
		 // X
		static float inflexPoint1 = ( screenResoultionX / countOfverticalLines ) * 1;
		static float maxPoint1 = ( screenResoultionX / countOfverticalLines ) * 2;
		static float inflexPoint2 = ( screenResoultionX / countOfverticalLines ) * 3;
		static float maxPoint2 = ( screenResoultionX / countOfverticalLines ) * 4;
		static float inflexPoint3 = ( screenResoultionX / countOfverticalLines ) * 5;
		static float maxPoint3 = ( screenResoultionX / countOfverticalLines ) * 6;
		static float inflexPoint4 = ( screenResoultionX / countOfverticalLines ) * 7;
		static float maxPoint4 = ( screenResoultionX / countOfverticalLines ) * 8;
		static float inflexPoint5 = ( screenResoultionX / countOfverticalLines ) * 9;
		static float maxPoint5 = ( screenResoultionX / countOfverticalLines ) * 10;
		static float inflexPoint6 = ( screenResoultionX / countOfverticalLines ) * 11;
		static float maxPoint6 = ( screenResoultionX / countOfverticalLines ) * 12;
		static float inflexPoint7 = ( screenResoultionX / countOfverticalLines ) * 13;
		static float maxPoint7 = ( screenResoultionX / countOfverticalLines ) * 14;
		static float inflexPoint8 = ( screenResoultionX / countOfverticalLines ) * 15;
		static float maxPoint8 = ( screenResoultionX / countOfverticalLines ) * 16;
		 

		 // Y
		static float countOfHorizontalLines = 6;
		static float level0 = ( screenResoultionY / 2 );
		static float level1 = level0 - (((screenResoultionY / 2) / countOfHorizontalLines ) * 1);
		static float level2 = level0 - (((screenResoultionY / 2) / countOfHorizontalLines ) * 2);
		static float level3 = level0 - (((screenResoultionY / 2) / countOfHorizontalLines ) * 3);
		static float level4 = level0 - (((screenResoultionY / 2) / countOfHorizontalLines ) * 4);
		static float level5 = level0 - (((screenResoultionY / 2) / countOfHorizontalLines ) * 5);
		static float level6 = level0 - (((screenResoultionY / 2) / countOfHorizontalLines ) * 6);
		static float levelN1 = level0 + (((screenResoultionY / 2) / countOfHorizontalLines ) * 1);
		static float levelN2 = level0 + (((screenResoultionY / 2) / countOfHorizontalLines ) * 2);
		static float levelN3 = level0 + (((screenResoultionY / 2) / countOfHorizontalLines ) * 3);
		static float levelN4 = level0 + (((screenResoultionY / 2) / countOfHorizontalLines ) * 4);
		static float levelN5 = level0 + (((screenResoultionY / 2) / countOfHorizontalLines ) * 5);
		static float levelN6 = level0 + (((screenResoultionY / 2) / countOfHorizontalLines ) * 6);
		 
		static float[] lvlArray = {levelN6,
				 			 levelN5,
			 				 levelN4,
							 levelN3,
							 levelN2,
							 levelN1,
							 level0, 
							 level1, 
							 level2,
							 level3,
							 level4,
							 level5,
							 level6};

		 // LINE horizontal
		static Color lineColors = Color.rgb(83, 150, 125);
	     // high light cross
		static Color HighLightLineColor = Color.rgb(167, 232, 208);
		 
	     //Line Horizontal
	     static Line lineH0 = new Line(startPointX, startPointY, endPointX, endPointY);
	     static Line lineH1 = new Line(startPointX, level1, endPointX, level1);
	     static Line lineH2 = new Line(startPointX, level2, endPointX, level2);
	     static Line lineH3 = new Line(startPointX, level3, endPointX, level3);
	     static Line lineH4 = new Line(startPointX, level4, endPointX, level4);
	     static Line lineH5 = new Line(startPointX, level5, endPointX, level5);
	     static Line lineHN1 = new Line(startPointX, levelN1, endPointX, levelN1);
	     static Line lineHN2 = new Line(startPointX, levelN2, endPointX, levelN2);
	     static Line lineHN3 = new Line(startPointX, levelN3, endPointX, levelN3);
	     static Line lineHN4 = new Line(startPointX, levelN4, endPointX, levelN4);
	     static Line lineHN5 = new Line(startPointX, levelN5, endPointX, levelN5);
	     
	     static Line[] lineHorizontalArray = { 
					lineHN5,
					lineHN4,
					lineHN3,
					lineHN2,
					lineHN1,
					lineH0,
					lineH1,
					lineH2,
					lineH3,
					lineH4,
					lineH5
					};
	     
	     
	     //Line Vertical
	     static Line line0 = new Line(maxPoint1, 0, maxPoint1, screenResoultionY);
	     static Line line1 = new Line(maxPoint2, 0, maxPoint2, screenResoultionY);
	     static Line line2 = new Line(maxPoint3, 0, maxPoint3, screenResoultionY);
	     static Line line3 = new Line(maxPoint4, 0, maxPoint4, screenResoultionY);
	     static Line line4 = new Line(maxPoint5, 0, maxPoint5, screenResoultionY);
	     static Line line5 = new Line(maxPoint6, 0, maxPoint6, screenResoultionY);
	     static Line line6 = new Line(maxPoint7, 0, maxPoint7, screenResoultionY);
	     static Line line7 = new Line(maxPoint8, 0, maxPoint8, screenResoultionY);
	     
	     static Line[] lineVerticalArray = {
	    		 	line0,
					line1,
					line2,
					line3,
					line4,
					line5,
					line6,
					line7
					};
	     
	     //Drawing a cubic curve 
	     static CubicCurve cubicCurve0 = new CubicCurve(); 
	     static CubicCurve cubicCurve1 = new CubicCurve(); 
	     static CubicCurve cubicCurve2 = new CubicCurve(); 
	     static CubicCurve cubicCurve3 = new CubicCurve(); 
	     static CubicCurve cubicCurve4 = new CubicCurve();
	     static CubicCurve cubicCurve5 = new CubicCurve();
	     static CubicCurve cubicCurve6 = new CubicCurve();
	     static CubicCurve cubicCurve7 = new CubicCurve();
	     
	     static CubicCurve[] cubiCurveArray = {cubicCurve0, 
	    		 						cubicCurve1, 
	    		 						cubicCurve2,
	    		 						cubicCurve3,
	    		 						cubicCurve4,
	    		 						cubicCurve5,
	    		 						cubicCurve6,
	    		 						cubicCurve7};
	     
	     //Creating a Group object  
	     static Group root = new Group(lineH0,
	    		 				lineH1,
	    		 				lineH2,
	    		 				lineH3,
	    		 				lineH4,
	    		 				lineH5,
	    		 				lineHN1,
	    		 				lineHN2,
	    		 				lineHN3,
	    		 				lineHN4,
	    		 				lineHN5,
	    		 				line0,
	    		 				line1,
	    		 				line2,
	    		 				line3,
	    		 				line4,
	    		 				line5,
	    		 				line6,
	    		 				line7,
	    		 				cubicCurve0,
	    		 				cubicCurve1, 
	    		 				cubicCurve2, 
	    		 				cubicCurve3, 
	    		 				cubicCurve4,
	    		 				cubicCurve5,
	    		 				cubicCurve6,
	    		 				cubicCurve7
	    		 				);
	     
	     static Scene scene = new Scene(root, screenResoultionX, screenResoultionY);
	     
	     //effects
	     static Shadow shadow = new Shadow();
	     static InnerShadow innerShadow = new InnerShadow();
	     static Blend blend = new Blend();
	
	 @Override 
	   public void start(Stage stage) {

		 
		 
		 setSceneBlack();
	     
	     
	     // EVENTs
	     scene.setOnKeyPressed(e -> {
	    	 
	    		 
	    	 
	    	 	if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.NUMPAD4 ) {
	    	 		if(gameEnable == true) {
	    	 			
	    	 		
	    	 		currentVerticalLevel = currentVerticalLevel - 1;
	    	 		if(currentVerticalLevel < 0) {
	    	 			currentVerticalLevel = 0;
	    	 		}
	    	 		
	    	 		for(int i = 0; i < lineVerticalArray.length; i++) {
	    	 			lineVerticalArray[i].setStroke(lineColors);
	    	 		}
	    	 		for(int i = 0; i < lineHorizontalArray.length; i++) {
	    	 			lineHorizontalArray[i].setStroke(lineColors);
	    	 		}
	    	 		lineVerticalArray[currentVerticalLevel].setStroke(HighLightLineColor);
	    	 		lineHorizontalArray[currentLevel[currentVerticalLevel] - 1].setStroke(HighLightLineColor);
	    	 		
	    	 		System.out.println(currentVerticalLevel);
	    	 	}
	    	 	}
	    	 	if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.NUMPAD6 ) {
	    	 		if(gameEnable == true) {
	    	 		currentVerticalLevel = currentVerticalLevel + 1;
	    	 		if(currentVerticalLevel > 6) {
	    	 			currentVerticalLevel = 6;
	    	 		}
	    	 		
	    	 		for(int i = 0; i < lineVerticalArray.length; i++) {
	    	 			lineVerticalArray[i].setStroke(lineColors);
	    	 		}
	    	 		for(int i = 0; i < lineHorizontalArray.length; i++) {
	    	 			lineHorizontalArray[i].setStroke(lineColors);
	    	 		}
	    	 		lineVerticalArray[currentVerticalLevel].setStroke(HighLightLineColor);
	    	 		lineHorizontalArray[currentLevel[currentVerticalLevel] - 1].setStroke(HighLightLineColor);
	    	 		
	    	 		System.out.println(currentVerticalLevel);
	    	 		}
	    	 	}
		        if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.NUMPAD8 ) {
		        	if(gameEnable == true) {
		        	if(currentLevel[currentVerticalLevel] < 11 ) {
		        		
		        		for(int i = 0; i < lineVerticalArray.length; i++) {
		    	 			lineVerticalArray[i].setStroke(lineColors);
		    	 		}
		    	 		for(int i = 0; i < lineHorizontalArray.length; i++) {
		    	 			lineHorizontalArray[i].setStroke(lineColors);
		    	 		}
		    	 		lineVerticalArray[currentVerticalLevel].setStroke(HighLightLineColor);
		    	 		lineHorizontalArray[currentLevel[currentVerticalLevel]].setStroke(HighLightLineColor);		        		
		        		
		        		cubiCurveArray[currentVerticalLevel].setControlY2(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        		cubiCurveArray[currentVerticalLevel].setEndY(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        		cubiCurveArray[currentVerticalLevel+1].setStartY(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        		cubiCurveArray[currentVerticalLevel+1].setControlY1(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        	
		        		currentLevel[currentVerticalLevel] = currentLevel[currentVerticalLevel] + 1;
		        		if(currentLevel[currentVerticalLevel] > 11 ) {
		        			currentLevel[currentVerticalLevel] = 11;
		        		}
		        		System.out.println(currentLevel[currentVerticalLevel]);
		        	}
		        	}
		        }
		        if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.NUMPAD2) {
		        	if(gameEnable == true) {
		        	if(currentLevel[currentVerticalLevel] > 1 ) {
		        		
		        		for(int i = 0; i < lineVerticalArray.length; i++) {
		    	 			lineVerticalArray[i].setStroke(lineColors);
		    	 		}
		    	 		for(int i = 0; i < lineHorizontalArray.length; i++) {
		    	 			lineHorizontalArray[i].setStroke(lineColors);
		    	 		}
		    	 		lineVerticalArray[currentVerticalLevel].setStroke(HighLightLineColor);
		    	 		lineHorizontalArray[currentLevel[currentVerticalLevel] - 2].setStroke(HighLightLineColor);
		        		
		        		cubiCurveArray[currentVerticalLevel].setControlY2(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        		cubiCurveArray[currentVerticalLevel].setEndY(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        		cubiCurveArray[currentVerticalLevel+1].setStartY(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        		cubiCurveArray[currentVerticalLevel+1].setControlY1(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        	
		        		currentLevel[currentVerticalLevel] = currentLevel[currentVerticalLevel] - 1;
		        		if(currentLevel[currentVerticalLevel] < 1 ) {
		        			currentLevel[currentVerticalLevel] = 1;
		        		}
		        		System.out.println(currentLevel[currentVerticalLevel]);
		        	}
		        	}
		        }
		        
		        
		        if (e.getCode() == KeyCode.NUMPAD5) { 
		        	if(gameEnable == true) {
		        	setSceneShow();
		        	}
		        }
	    	
		    });
	      
	      //Setting title to the Stage 
	      stage.setTitle("Oscilloscope"); 
	         
	      //Adding scene to the stage
	      stage.setScene(scene); 
	      //stage.setFullScreen(true);
	        
	      //Displaying the contents of the stage 
	      stage.show(); 
	      setSceneBlack();
	      // Start Thread Work
	      new Thread(() -> {
	    	  while(true) {
	    		  try {
					Work.run();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	  }
	      }).start();
	      
	      // Start Thread TCP
		     new Thread(() -> {
		    	 TCP.ReadConfigFile();
		            while (true) {
		            	try {
		            		Thread.sleep(1000);
		            		
		            		TCP.ConnectionIsAlive = TCP.Connect();
		            		while(TCP.ConnectionIsAlive) {
		            			int readValue = 0;
		            			boolean writeDone = false;
		            			Work.fekete_doboz = TCP.read("read#LSTmini_pc.fekete_doboz");
			            		Work.kapcsolo_tabla_done = TCP.read("read#LSTmini_pc.kapcsolo_tabla_done");
			            		Work.boot = TCP.read("read#LSTmini_pc.boot");
			            		Work.status = TCP.read("read#LST_interface.status");
			            		Work.oszcilloszkop_skip = TCP.read("read#LSTmini_pc.oszcilloszkop_skip");
			            		
			            		
		            			writeDone = TCP.write("write#LSTmini_pc.oszcilloszkop_done#1");
			            		Thread.sleep(2000);

			            	}
		            	}catch(Exception e) {
		            		e.printStackTrace();
		            	}
		            	
		            	
		            }
		        }).start();
	   }    
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void setSceneBlack() {
		
		scene.setCursor(Cursor.NONE);
		
		for(int i = 0; i < lineVerticalArray.length; i++) {
			lineVerticalArray[i].setStroke(Color.BLACK);
		}
		
		for(int i = 0; i < lineHorizontalArray.length; i++) {
			lineHorizontalArray[i].setStroke(Color.BLACK);
		}
		
		shadow.setColor(Color.BLACK);  
		for(int i = 0; i < cubiCurveArray.length; i++) {
    		cubiCurveArray[i].setFill(Color.TRANSPARENT);
    		cubiCurveArray[i].setStroke(Color.BLACK);
    		cubiCurveArray[i].setStrokeWidth(4);
    		cubiCurveArray[i].setEffect(shadow);    		
	     }
		
		 
		 scene.setFill(Color.BLACK);
	}
	
	public static boolean setSceneShow() {
		//Line Horizontal
		 lineH0.setStroke(HighLightLineColor);
		 lineH1.setStroke(lineColors);		 
		 lineH2.setStroke(lineColors);		 
		 lineH3.setStroke(lineColors);		 
		 lineH4.setStroke(lineColors);		 
		 lineH5.setStroke(lineColors);		 
		 lineHN1.setStroke(lineColors);		 
		 lineHN2.setStroke(lineColors);		 
		 lineHN3.setStroke(lineColors);		 
		 lineHN4.setStroke(lineColors);		 
		 lineHN5.setStroke(lineColors);
		 
		 // Line Vertical
		 line0.setStroke(HighLightLineColor);		 
		 line1.setStroke(lineColors);		 
		 line2.setStroke(lineColors);		 
		 line3.setStroke(lineColors);		 
		 line4.setStroke(lineColors);		 
		 line5.setStroke(lineColors);		 
		 line6.setStroke(lineColors);		 
		 line7.setStroke(lineColors);
		 
		 //Effects
		 shadow.setBlurType(BlurType.ONE_PASS_BOX);  
		 shadow.setColor(Color.rgb(217, 250, 238));  
		 shadow.setHeight(80);  
		 shadow.setRadius(12);  
		 shadow.setWidth(50);
		  
		 innerShadow.setBlurType(BlurType.ONE_PASS_BOX);  
		 innerShadow.setColor(Color.rgb(137, 2, 201));  
		 innerShadow.setHeight(25);  
		 innerShadow.setRadius(12);  
		 innerShadow.setWidth(20);  
		 innerShadow.setChoke(0.9);
		 
		//Creating the blend
	     blend.setMode(BlendMode.ADD);
	     //Setting both the shadow effects to the blend
	     blend.setBottomInput(shadow);
	     //blend.setBottomInput(innerShadow);
	       
	    
	     
	     for(int i = 0; i < cubiCurveArray.length; i++) {
    		cubiCurveArray[i].setFill(Color.TRANSPARENT);
    		cubiCurveArray[i].setStroke(Color.rgb(137, 240, 201));
    		cubiCurveArray[i].setStrokeWidth(4);
    		cubiCurveArray[i].setEffect(shadow);
	     }
    	
		 //Setting properties to cubic curve 1
  	     cubicCurve0.setStartX(startPointX); 
  	     cubicCurve0.setStartY(startPointY); 
  	     cubicCurve0.setControlX1(inflexPoint1); 
  	     cubicCurve0.setControlY1(startPointY); 
  	     cubicCurve0.setControlX2(inflexPoint1); 
  	     cubicCurve0.setControlY2(level0); 
  	     cubicCurve0.setEndX(maxPoint1); 
  	     cubicCurve0.setEndY(level0); 
  	     		        			   	      
  	     //Setting properties to cubic curve 2
  	     cubicCurve1.setStartX(maxPoint1); 
  	     cubicCurve1.setStartY(level0); 
  	     cubicCurve1.setControlX1(inflexPoint2); 
  	     cubicCurve1.setControlY1(level0); 
  	     cubicCurve1.setControlX2(inflexPoint2); 
  	     cubicCurve1.setControlY2(level0); 
  	     cubicCurve1.setEndX(maxPoint2); 
  	     cubicCurve1.setEndY(level0);   
  	     
  	     //Setting properties to cubic curve 3
  	     cubicCurve2.setStartX(maxPoint2); 
  	     cubicCurve2.setStartY(level0); 
  	     cubicCurve2.setControlX1(inflexPoint3); 
  	     cubicCurve2.setControlY1(level0); 
  	     cubicCurve2.setControlX2(inflexPoint3); 
  	     cubicCurve2.setControlY2(level0); 
  	     cubicCurve2.setEndX(maxPoint3); 
  	     cubicCurve2.setEndY(level0);   
  	     
  	     //Setting properties to cubic curve 4
  	     cubicCurve3.setStartX(maxPoint3); 
  	     cubicCurve3.setStartY(level0); 
  	     cubicCurve3.setControlX1(inflexPoint4); 
  	     cubicCurve3.setControlY1(level0); 
  	     cubicCurve3.setControlX2(inflexPoint4); 
  	     cubicCurve3.setControlY2(level0); 
  	     cubicCurve3.setEndX(maxPoint4); 
  	     cubicCurve3.setEndY(level0);   
  	     
  	     //Setting properties to cubic curve 5
  	     cubicCurve4.setStartX(maxPoint4); 
  	     cubicCurve4.setStartY(level0); 
  	     cubicCurve4.setControlX1(inflexPoint5); 
  	     cubicCurve4.setControlY1(level0); 
  	     cubicCurve4.setControlX2(inflexPoint5); 
  	     cubicCurve4.setControlY2(level0); 
  	     cubicCurve4.setEndX(maxPoint5); 
  	     cubicCurve4.setEndY(level0);
  	     
  	     //Setting properties to cubic curve 6
  	     cubicCurve5.setStartX(maxPoint5); 
  	     cubicCurve5.setStartY(level0); 
  	     cubicCurve5.setControlX1(inflexPoint6); 
  	     cubicCurve5.setControlY1(level0); 
  	     cubicCurve5.setControlX2(inflexPoint6); 
  	     cubicCurve5.setControlY2(level0); 
  	     cubicCurve5.setEndX(maxPoint6); 
  	     cubicCurve5.setEndY(level0);
  	     
  	     //Setting properties to cubic curve 7
  	     cubicCurve6.setStartX(maxPoint6); 
  	     cubicCurve6.setStartY(level0); 
  	     cubicCurve6.setControlX1(inflexPoint7); 
  	     cubicCurve6.setControlY1(level0); 
  	     cubicCurve6.setControlX2(inflexPoint7); 
  	     cubicCurve6.setControlY2(endPointY); 
  	     cubicCurve6.setEndX(maxPoint7); 
  	     cubicCurve6.setEndY(level0);
  	     
  	     //Setting properties to cubic curve 8
  	     cubicCurve7.setStartX(maxPoint7); 
  	     cubicCurve7.setStartY(level0); 
  	     cubicCurve7.setControlX1(inflexPoint8); 
  	     cubicCurve7.setControlY1(level0); 
  	     cubicCurve7.setControlX2(inflexPoint8); 
  	     cubicCurve7.setControlY2(endPointY); 
  	     cubicCurve7.setEndX(maxPoint8); 
  	     cubicCurve7.setEndY(endPointY);
	       
	     //Creating a scene object 
	     scene.setFill(Color.rgb(15, 24, 22));
	     scene.setCursor(Cursor.NONE);
	     
	     for(int i = 0; i < currentLevel.length; i++) {
     		currentLevel[i] = 6;
     	 }
	     
	     currentVerticalLevel = 0;
	     
	     gameEnable = true;
	     
	     return true;
	}

}
