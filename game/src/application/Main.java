package application;
	


import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;
import javafx.scene.shape.QuadCurve; 
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;  
import javafx.scene.effect.BoxBlur;
import javafx.scene.shape.CubicCurve;
import javafx.scene.effect.Shadow;
import javafx.scene.input.KeyCode;
import javafx.scene.effect.BlurType;
import javafx.scene.shape.Line;
import javafx.scene.effect.InnerShadow; 
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class Main extends Application {
	// Steps
		int[] currentLevel = {4, 4, 4, 4, 4}; // = 0
		int currentVerticalLevel = 0;
	
	 @Override 
	   public void start(Stage stage) {
		 
		 Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		 
		 float screenResoultionX = (float)screenBounds.getMaxX();
		 float screenResoultionY = (float)screenBounds.getMaxY();;
		 
		 float usedScreenX = (screenResoultionX / 100) * 90;
 		 
		 float startPointX = 0.0f;
		 float startPointY = screenResoultionY / 2;
		 float endPointX = screenResoultionX;
		 float endPointY = startPointY;
		 
		 float countOfverticalLines = 12;
		 // X
		 float inflexPoint1 = ( screenResoultionX / countOfverticalLines ) * 1;
		 float maxPoint1 = ( screenResoultionX / countOfverticalLines ) * 2;
		 float inflexPoint2 = ( screenResoultionX / countOfverticalLines ) * 3;
		 float maxPoint2 = ( screenResoultionX / countOfverticalLines ) * 4;
		 float inflexPoint3 = ( screenResoultionX / countOfverticalLines ) * 5;
		 float maxPoint3 = ( screenResoultionX / countOfverticalLines ) * 6;
	 	 float inflexPoint4 = ( screenResoultionX / countOfverticalLines ) * 7;
		 float maxPoint4 = ( screenResoultionX / countOfverticalLines ) * 8;
		 float inflexPoint5 = ( screenResoultionX / countOfverticalLines ) * 9;
		 float maxPoint5 = ( screenResoultionX / countOfverticalLines ) * 10;
		 float inflexPoint6 = ( screenResoultionX / countOfverticalLines ) * 11;
		 float maxPoint6 = ( screenResoultionX / countOfverticalLines ) * 12;


		 // Y
		 float level0 = ( screenResoultionY / 2 );
		 float level1 = level0 - (((screenResoultionY / 2) / 4 ) * 1);
		 float level2 = level0 - (((screenResoultionY / 2) / 4 ) * 2);
		 float level3 = level0 - (((screenResoultionY / 2) / 4 ) * 3);
		 float level4 = level0 - (((screenResoultionY / 2) / 4 ) * 4);
		 float levelN1 = level0 + (((screenResoultionY / 2) / 4 ) * 1);
		 float levelN2 = level0 + (((screenResoultionY / 2) / 4 ) * 2);
		 float levelN3 = level0 + (((screenResoultionY / 2) / 4 ) * 3);
		 float levelN4 = level0 + (((screenResoultionY / 2) / 4 ) * 4);
		 
		 float[] lvlArray = {levelN4,
							 levelN3,
							 levelN2,
							 levelN1,
							 level0, 
							 level1, 
							 level2,
							 level3,
							 level4};

		 
		 
		 // LINE
		 Color lineColors = Color.rgb(83, 150, 125);
		 
		 Line lineV0 = new Line(startPointX, startPointY, endPointX, endPointY);
		 lineV0.setStroke(lineColors);
		 
		 Line lineV1 = new Line(startPointX, level1, endPointX, level1);
		 lineV1.setStroke(lineColors);
		 
		 Line lineV2 = new Line(startPointX, level2, endPointX, level2);
		 lineV2.setStroke(lineColors);
		 
		 Line lineV3 = new Line(startPointX, level3, endPointX, level3);
		 lineV3.setStroke(lineColors);
		 
		 Line lineV4 = new Line(startPointX, level4, endPointX, level4);
		 lineV4.setStroke(lineColors);
		 
		 Line lineVN1 = new Line(startPointX, levelN1, endPointX, levelN1);
		 lineVN1.setStroke(lineColors);
		 
		 Line lineVN2 = new Line(startPointX, levelN2, endPointX, levelN2);
		 lineVN2.setStroke(lineColors);
		 
		 Line lineVN3 = new Line(startPointX, levelN3, endPointX, levelN3);
		 lineVN3.setStroke(lineColors);
		 
		 Line lineVN4 = new Line(startPointX, levelN4, endPointX, levelN4);
		 lineVN4.setStroke(lineColors);
		 
		 
		 Line line0 = new Line(maxPoint1, 0, maxPoint1, screenResoultionY);
		 line0.setStroke(lineColors);
		 
		 Line line1 = new Line(maxPoint2, 0, maxPoint2, screenResoultionY);
		 line1.setStroke(lineColors);
		 
		 Line line2 = new Line(maxPoint3, 0, maxPoint3, screenResoultionY);
		 line2.setStroke(lineColors);
		 
		 Line line3 = new Line(maxPoint4, 0, maxPoint4, screenResoultionY);
		 line3.setStroke(lineColors);
		 
		 Line line4 = new Line(maxPoint5, 0, maxPoint5, screenResoultionY);
		 line4.setStroke(lineColors);
		 
		/* Line line5 = new Line(maxPoint6, 0, maxPoint6, screenResoultionY);
		 line5.setStroke(lineColors);*/
		 
		 //effects
		 Shadow shadow = new Shadow();  
		 shadow.setBlurType(BlurType.ONE_PASS_BOX);  
		 shadow.setColor(Color.rgb(217, 250, 238));  
		 shadow.setHeight(80);  
		 shadow.setRadius(12);  
		 shadow.setWidth(50);
		 
		 InnerShadow innerShadow = new InnerShadow();  
		 innerShadow.setBlurType(BlurType.ONE_PASS_BOX);  
		 innerShadow.setColor(Color.rgb(137, 2, 201));  
		 innerShadow.setHeight(25);  
		 innerShadow.setRadius(12);  
		 innerShadow.setWidth(20);  
		 innerShadow.setChoke(0.9);
		 
		//Creating the blend
	     Blend blend = new Blend();
	     blend.setMode(BlendMode.ADD);
	     //Setting both the shadow effects to the blend
	     blend.setBottomInput(shadow);
	     //blend.setBottomInput(innerShadow);
	        
	     // Create Lines
	     // Horisontal
	      
	     //Drawing a cubic curve 
	     CubicCurve cubicCurve0 = new CubicCurve(); 
	     CubicCurve cubicCurve1 = new CubicCurve(); 
	     CubicCurve cubicCurve2 = new CubicCurve(); 
	     CubicCurve cubicCurve3 = new CubicCurve(); 
	     CubicCurve cubicCurve4 = new CubicCurve();
	     CubicCurve cubicCurve5 = new CubicCurve();
	     
	     CubicCurve[] cubiCurveArray = {cubicCurve0, 
	    		 						cubicCurve1, 
	    		 						cubicCurve2,
	    		 						cubicCurve3,
	    		 						cubicCurve4,
	    		 						cubicCurve5};
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
   	     cubicCurve5.setControlY2(endPointY); 
   	     cubicCurve5.setEndX(maxPoint6); 
   	     cubicCurve5.setEndY(endPointY);   
	     
	        
	     //Creating a Group object  
	     Group root = new Group(lineV0,
	    		 				lineV1,
	    		 				lineV2,
	    		 				lineV3,
	    		 				lineV4,
	    		 				lineVN1,
	    		 				lineVN2,
	    		 				lineVN3,
	    		 				lineVN4,
	    		 				line0,
	    		 				line1,
	    		 				line2,
	    		 				line3,
	    		 				line4,
	    		 				//line5,
	    		 				cubicCurve0,
	    		 				cubicCurve1, 
	    		 				cubicCurve2, 
	    		 				cubicCurve3, 
	    		 				cubicCurve4,
	    		 				cubicCurve5); 
	        
	     //Creating a scene object 
	     Scene scene = new Scene(root, screenResoultionX, screenResoultionY);  
	     scene.setFill(Color.rgb(15, 24, 22));
	     
	     
	     // EVENTs
	     scene.setOnKeyPressed(e -> {
	    	 	if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.NUMPAD4 ) {
	    	 		currentVerticalLevel = currentVerticalLevel - 1;
	    	 		if(currentVerticalLevel < 0) {
	    	 			currentVerticalLevel = 0;
	    	 		}
	    	 		System.out.println(currentVerticalLevel);
	    	 	}
	    	 	if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.NUMPAD6 ) {
	    	 		currentVerticalLevel = currentVerticalLevel + 1;
	    	 		if(currentVerticalLevel > 4) {
	    	 			currentVerticalLevel = 4;
	    	 		}
	    	 		System.out.println(currentVerticalLevel);
	    	 	}
		        if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.NUMPAD8 ) {
		        	if(currentLevel[currentVerticalLevel] < 8 ) {
		        	cubiCurveArray[currentVerticalLevel].setControlY2(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        	cubiCurveArray[currentVerticalLevel].setEndY(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        	cubiCurveArray[currentVerticalLevel+1].setStartY(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        	cubiCurveArray[currentVerticalLevel+1].setControlY1(lvlArray[currentLevel[currentVerticalLevel]+1]);
		        	
		        	currentLevel[currentVerticalLevel] = currentLevel[currentVerticalLevel] + 1;
		        	if(currentLevel[currentVerticalLevel] > 8 ) {
		        		currentLevel[currentVerticalLevel] = 8;
		        	}
		        	System.out.println(currentLevel[currentVerticalLevel]);
		        	}
		        }
		        if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.NUMPAD2) {
		        	if(currentLevel[currentVerticalLevel] > 0 ) {
		        	cubiCurveArray[currentVerticalLevel].setControlY2(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        	cubiCurveArray[currentVerticalLevel].setEndY(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        	cubiCurveArray[currentVerticalLevel+1].setStartY(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        	cubiCurveArray[currentVerticalLevel+1].setControlY1(lvlArray[currentLevel[currentVerticalLevel]-1]);
		        	
		        	currentLevel[currentVerticalLevel] = currentLevel[currentVerticalLevel] - 1;
		        	if(currentLevel[currentVerticalLevel] < 0 ) {
		        		currentLevel[currentVerticalLevel] = 0;
		        	}
		        	System.out.println(currentLevel[currentVerticalLevel]);
		        	}
		        }
		        
		        
		        if (e.getCode() == KeyCode.NUMPAD5) {
		        	for(int i = 0; i < currentLevel.length; i++) {
		        		currentLevel[i] = 4;
		        	}
		        	
		        	for(int i = 0; i < cubiCurveArray.length; i++) {
		        		cubiCurveArray[i].setFill(Color.TRANSPARENT);
		        		cubiCurveArray[i].setStroke(Color.rgb(112, 212, 175));
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
			   	     cubicCurve5.setControlY2(endPointY); 
			   	     cubicCurve5.setEndX(maxPoint6); 
			   	     cubicCurve5.setEndY(endPointY);   
		        }
		    });
	      
	     // Start Thread TCP
	     new Thread(() -> {
	            while (true) {
	            	try {
	            		Thread.sleep(1000);
	            		TCP.ConnectionIsAlive = TCP.Connect();
	            		while(TCP.ConnectionIsAlive) {
		            		TCP.run();
		            	}
	            	}catch(Exception e) {
	            		e.printStackTrace();
	            	}
	            	
	            	
	            }
	        }).start();
	     
	      //Setting title to the Stage 
	      stage.setTitle("Oscilloscope"); 
	         
	      //Adding scene to the stage
	      stage.setScene(scene); 
	      //stage.setFullScreen(true);
	        
	      //Displaying the contents of the stage 
	      stage.show(); 
	   }    
	
	public static void main(String[] args) {
		launch(args);
	}

}
