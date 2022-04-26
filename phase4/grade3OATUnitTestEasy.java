package phase3;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class grade3OATUnitTestEasy extends JFrame {

	/**
	 * Creates new form grade3OATUnitTestEasy
	 */														//THIS IS A UNIT TEST. IGNORE ANY COMMENTS ABOUT THE HINT FUNCTION.
	
																		//Overview of how this test functions:
	
	//There are 5 questions
	
	//There are 5 submitAnswer buttons, 5 hint buttons, 5 arrow buttons (these are buttonA, buttonB, buttonC, buttonD, and buttonF), and there are 5 text fields that read input from the user. These text fields are textAnswer, questionB, questionC, questionD, and questionE
	//All 5 submitAnswer buttons are stacked on top of each other, all 5 hint buttons are stacked on top of each other, all 5 arrow buttons are stacked on top of each other, and all 5 text fields are stacked on top of each other
	//Only one of each is visible at a time	
	//Once the user clicks a submitAnswer button, that current button will be made invisible, the current text field will be disabled (meaning it can't be edited), and an arrow button will trigger
	//Once the user clicks the arrow, that current arrow button and the current text field will be made invisible, and the next submitAnswer button and text field will trigger
	//The user can manually call for a hint by selecting the question mark icon. This will not affect their score.
	//If the user enters an incorrect answer in 3 times, the correct answer in addition to an explanation will pop up. This occurring will mark the question as incorrect.
	//This repeats until the test is complete
	//Once the test finishes, the user will be able to click a button (called resultsBut) to display the results
	//This button sets the visibility of the 5 text fields from each question to true, and resizes + repositions them neatly so the user can view the answers that they entered into each text field in the order that they answered them
	//Eventually the questions, in addition to an indication of which answers they received credit for, will be placed alongside the answer text fields
	
	//Randomization is modulated by a method called randomFill(), which creates a range of numbers between a minimum and maximum value, which are specified when the method is called
	//There are three variables, i, j, k which are initiated with a random number via randomFill(), and are then used to populate the string arrays questions[] and answer[]
	//These arrays contain the mathematical operators used to make different problem types, and each element in questions[] represents a different question type 
	//Elements from the answer[] array are compared with the user's input to determine a correct answer
	//The order of the questions is not random, but the values always are
	
	//Kind of a crude implementation but it works and it's flexible
	
	
	int index; //index that is used to keep track of the question that the user's on
	int correct_guesses = 0; //When the user answers a question correctly, this value gets incremented. At the end of the test, this value divided by the value of total_questions produces the final score
	int total_questions = 5; //We can adjust this as needed if we want more questions. Would just have to add more questions and answers to the arrays
	
	int result;
	int clicked = 0;

	//Buttons A-D, and F are the arrow buttons
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JButton buttonE = new JButton();
	JButton buttonF = new JButton();
	
	JButton beginTest = new JButton("CLICK TO START TEST!"); //This button is the first button the user will see when the test launches. They will click it to begin the test
	JLabel instructionLabel = new JLabel("YOU WILL HAVE 1 CHANCE TO ANSWER EACH QUESTION CORRECTLY");
	JButton submitAnswer = new JButton("SUBMIT ANSWER"); //Submit answer button declarations
	JButton submitAnswer5 = new JButton("SUBMIT ANSWER");
	JButton submitAnswer4 = new JButton("SUBMIT ANSWER");
	JButton submitAnswer3 = new JButton("SUBMIT ANSWER");
	JButton submitAnswer2 = new JButton("SUBMIT ANSWER");
	
	JLabel maybe = new JLabel(""); //ignore
	
	JButton question1 = new JButton();

	JButton question2 = new JButton();
		
	
	JButton question3 = new JButton();

	JButton question4 = new JButton();
	
	JButton question5 = new JButton();
	
	
	//these text fields are not related to the 5 text fields that are used to get user input
	JTextField textField1 = new JTextField() { //this text field is the header that displays the question the user is on
		 @Override public void setBorder(Border border) {
		} 
		};
	
	JTextField number_right = new JTextField() { //This  text field is used to display the total of correct questions compared to the number of total questions when the results are displayed
		 @Override public void setBorder(Border border) {
			} 
			};
	JTextField percentage = new JTextField() { //Same as above except it shows a percentage
		 @Override public void setBorder(Border border) {
			} 
			};
			
			JLabel correctAnswer = new JLabel(); //Jlabel used for checkmark displayed for correct answers
			JLabel incorrectAnswer = new JLabel(); //Jlabel used for red x displayed for incorrect answers
			
			
			JTextPane correctInWords = new JTextPane() { //textpane that displays "CORRECT!" or "INCORRECT" in text after an answer is submitted
				public void setBorder(Border border) {
				}
			};
			
			

	public grade3OATUnitTestEasy() {
		initComponents();
		shortAnswerTestGenerator();
		setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		getContentPane().setSize(dim.width, dim.height);

	}
	
	//method for randomizing values
	public int randomFill(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	//cluster method where all our buttons, labels, and other stuff gets initiated. should probably try to clean this up at some point
	private void initComponents() {
		
		
		homebut = new JButton();
		homebut.setBorder(null);
		homebut.setBounds(0, 133, 160, 52);
		profilebut = new JButton();
		profilebut.setBounds(0, 204, 212, 52);
		progressbut = new JButton();
		progressbut.setBounds(0, 275, 235, 51);
		classbut = new JButton();
		classbut.setBounds(0, 340, 225, 51);
		unitbut = new JButton();
		unitbut.setBounds(0, 414, 174, 51);
		rewardsbut = new JButton();
		rewardsbut.setBounds(0, 488, 190, 52);
		helpbut = new JButton();
		helpbut.setBounds(0, 559, 235, 52);
		header = new JLabel();
		header.setBounds(260, 136, 763, 140);
		header.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/opacitymaybe.png")));
		numcrunch = new JLabel();
		numcrunch.setBounds(20, 0, 225, 60);
		sidebar = new JLabel();
		sidebar.setBounds(0, 0, 260, 734);
		sidebar.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/opacitymaybe2.png")));
		back = new JLabel();
		back.setBounds(0, 0, 1024, 763);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1024, 763));
		setSize(new Dimension(1024, 763));

		label = new JLabel();
		label.setText("Crunchers");
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT,
					grade3OATUnitTestEasy.class.getResourceAsStream("MPLUSRounded1c-Black.ttf"));
			label.setFont(font.deriveFont(Font.BOLD, 35f));
		} catch (Exception e) {
		}
		getContentPane().setLayout(null);


		headerTitle = new JLabel("New label");
		headerTitle.setBounds(447, 156, 713, 100);
		getContentPane().add(headerTitle);
		headerTitle.setText("Grade 3 O/A Unit Test");
		headerTitle.setFont(new Font("Roboto", Font.BOLD, 30));
		headerTitle.setForeground(new Color(255, 255, 255));

		panel = new JPanel();
		panel.setBounds(280, 340, 690, 373);
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
		panel.setLayout(null);



		textAnswer = new JTextField();
		textAnswer.setVisible(false);
		
		try{
			 Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
				question1.setOpaque(false);
				question1.setContentAreaFilled(false);
				question1.setBounds(100, 67, 152, 27);
				question1.setVisible(false);
				instructionLabel.setFont(font.deriveFont(Font.BOLD, 15f));
				instructionLabel.setBounds(67, 155, 613, 52);
				panel.add(instructionLabel);
	           question1.setFont(font.deriveFont(Font.BOLD, 15f));
	           panel.add(question1);
	           question2.setBorderPainted(false);
	           question2.setContentAreaFilled(false);
	           question2.setOpaque(false);
	           question2.setBounds(100, 117, 152, 27);
	           question2.setVisible(false);
	           question2.setFont(font.deriveFont(Font.BOLD, 15f));
	           panel.add(question2);
	           question3.setContentAreaFilled(false);
	           question3.setBorderPainted(false);
	           question3.setBounds(100, 167, 152, 27);
	           question3.setVisible(false);
	           question3.setFont(font.deriveFont(Font.BOLD, 15f));
	           panel.add(question3);
	           question4.setBorderPainted(false);
	           question4.setContentAreaFilled(false);
	           question4.setBounds(100, 217, 152, 27);
	           question4.setVisible(false);
	           question4.setFont(font.deriveFont(Font.BOLD, 15f));
	           panel.add(question4);
	           question5.setContentAreaFilled(false);
	           question5.setBorderPainted(false);
	           question5.setBounds(100, 267, 152, 27);
	           question5.setVisible(false);
	           question5.setFont(font.deriveFont(Font.BOLD, 15f));
	           panel.add(question5);
	       }
		catch(Exception e){}

		
		textAnswer.setFont(new Font("Dialog", Font.BOLD, 25));
		textAnswer.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textAnswer.setBounds(183, 192, 274, 63);
		textAnswer.setBackground(new Color(226, 225, 225));
		panel.add(textAnswer);
		textAnswer.setColumns(10);
		
		textArea5 = new JTextPane() {
			public void setBorder(Border border) {
			}
		};
		textArea5.setVisible(false);
		textArea5.setOpaque(false);
		textArea5.setFont(new Font("Calibri", Font.BOLD, 16));
		
		
		
		textField1.setSize(387, 52);
		textField1.setLocation(131, 28);
		
		
		textField1.setForeground(new Color(48, 126, 143));
		textField1.setHorizontalAlignment(JTextField.CENTER);
		textField1.setEditable(false);
		textField1.setVisible(true);
		textField1.setColumns(10);
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	           textField1.setFont(font.deriveFont(Font.BOLD, 35f));
		}
		catch(Exception e){}
		panel.add(textField1);
		number_right.setVisible(false);
		
		
		number_right.setBounds(484, 121, 116, 50);
		panel.add(number_right);
		number_right.setBackground(new Color(255,255,255));
		number_right.setForeground(new Color(0,0,0));
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	           number_right.setFont(font.deriveFont(Font.BOLD, 25f));
	       }
	       catch(Exception e){}
		
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		percentage.setVisible(false);
		percentage.setBounds(484, 170, 116, 50);
		panel.add(percentage);
		percentage.setPreferredSize(new Dimension(50, 50));
		percentage.setBackground(new Color(255,255,255));
		percentage.setForeground(new Color(0,0,0));
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	           percentage.setFont(font.deriveFont(Font.BOLD, 25f));
	       }
	       catch(Exception e){}
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		
		
		textArea5.setContentType("text/html");
		textArea5.setText("<b></b>");
		textArea5.setEditable(false);
		
		textArea5.setForeground(new Color(0, 0, 0));
		textArea5.setBounds(188, 91, 274, 99);
		panel.add(textArea5);

		
		correctAnswer.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/correctCheck5.png")));
		correctAnswer.setVisible(false);
		correctAnswer.setBounds(472, 135, 100, 106);
		panel.add(correctAnswer);

		
		incorrectAnswer.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/incorrectX.png")));
		incorrectAnswer.setVisible(false);
		incorrectAnswer.setBounds(472, 135, 100, 106);
		panel.add(incorrectAnswer);
		

		
		buttonA.setPressedIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonA.setOpaque(false);
		buttonA.setRolloverIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonA.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrow.png")));
		buttonA.setFocusable(false);
		buttonA.setContentAreaFilled(false);
		buttonA.setBorderPainted(false);
		buttonA.setBorder(null);
		buttonA.setVisible(false);
		buttonA.setBounds(554, 282, 136, 87);
		panel.add(buttonA);

		
		buttonB.setPressedIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonB.setOpaque(false);
		buttonB.setFocusable(false);
		buttonB.setRolloverIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonB.setBorder(null);
		buttonB.setBorderPainted(false);
		buttonB.setContentAreaFilled(false);
		buttonB.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrow.png")));
		buttonB.setVisible(false);
		buttonB.setBounds(554, 282, 136, 87);
		panel.add(buttonB);

		
		buttonC.setPressedIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonC.setOpaque(false);
		buttonC.setRolloverIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonC.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrow.png")));
		buttonC.setFocusable(false);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		buttonC.setBorder(null);
		buttonC.setBounds(554, 282, 136, 87);
		buttonC.setVisible(false);
		panel.add(buttonC);

		
		buttonD.setOpaque(false);
		buttonD.setPressedIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonD.setRolloverIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonD.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrow.png")));
		buttonD.setFocusable(false);
		buttonD.setContentAreaFilled(false);
		buttonD.setBorderPainted(false);
		buttonD.setBorder(null);
		buttonD.setBounds(554, 282, 136, 87);
		buttonD.setVisible(false);
		panel.add(buttonD);

		
		buttonE.setPressedIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonE.setRolloverIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowHover.png")));
		buttonE.setOpaque(false);
		buttonE.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrow.png")));
		buttonE.setFocusable(false);
		buttonE.setContentAreaFilled(false);
		buttonE.setBorderPainted(false);
		buttonE.setBorder(null);
		buttonE.setBounds(554, 282, 136, 87);
		buttonE.setVisible(false);
		panel.add(buttonE);
		buttonF.setRolloverIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/goldenArrowHover (2).png")));

		buttonF.setOpaque(false);
		buttonF.setIcon(new ImageIcon(grade3OATUnitTestEasy.class.getResource("Images/arrowMoveOn.png")));
		buttonF.setFocusable(false);
		buttonF.setContentAreaFilled(false);
		buttonF.setBorderPainted(false);
		buttonF.setBorder(null);
		buttonF.setBounds(554, 282, 136, 87);
		buttonF.setVisible(false);
		panel.add(buttonF);
		
		
		
		beginTest.setFocusable(false);
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	           beginTest.setFont(font.deriveFont(Font.BOLD, 30f));
	       }
		catch(Exception e){}
		beginTest.setContentAreaFilled(false);
		beginTest.setForeground(new Color(0, 0, 0));
		beginTest.setBorder(null);
		beginTest.setBorderPainted(false);
		beginTest.setBounds(117, 94, 470, 52);
		panel.add(beginTest);
		
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	       }
		catch(Exception e){}
		
		
		
		
		
		
		correctInWords.setVisible(false);
		correctInWords.setText("");
		correctInWords.setForeground(new Color(0, 0, 0));
		correctInWords.setEditable(false);
	
		correctInWords.setBounds(193, 266, 274, 50);
		panel.add(correctInWords);
		
		
		
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	           correctInWords.setFont(font.deriveFont(Font.BOLD, 30f));
	           
	           
	           
	          
	          
	       }
		catch(Exception e){}
		
		 questionB = new JTextField();
		 questionB.setVisible(false);
         questionB.setFont(new Font("Dialog", Font.BOLD, 25));
         questionB.setColumns(10);
         questionB.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
         questionB.setBackground(new Color(226, 225, 225));
         questionB.setBounds(188, 157, 274, 63);
         panel.add(questionB);
         
         questionC = new JTextField();
         questionC.setVisible(false);
         questionC.setFont(new Font("Dialog", Font.BOLD, 25));
         questionC.setColumns(10);
         questionC.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
         questionC.setBackground(new Color(226, 225, 225));
         questionC.setBounds(188, 157, 274, 63);
         panel.add(questionC);
         
         questionF = new JTextField();
         questionF.setVisible(false);
         questionF.setFont(new Font("Dialog", Font.BOLD, 25));
         questionF.setColumns(10);
         questionF.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
         questionF.setBackground(new Color(226, 225, 225));
         questionF.setBounds(188, 157, 274, 63);
         panel.add(questionF);
         
         questionE = new JTextField();
         questionE.setVisible(false);
         questionE.setFont(new Font("Dialog", Font.BOLD, 25));
         questionE.setColumns(10);
         questionE.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
         questionE.setBackground(new Color(226, 225, 225));
         questionE.setBounds(188, 157, 274, 63);
         panel.add(questionE);
         
         questionD = new JTextField();
         questionD.setVisible(false);
         questionD.setFont(new Font("Dialog", Font.BOLD, 25));
         questionD.setColumns(10);
         questionD.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
         questionD.setBackground(new Color(226, 225, 225));
         questionD.setBounds(188, 157, 274, 63);
         panel.add(questionD);
		submitAnswer.setVisible(false);
		
		
		submitAnswer.setBounds(153, 266, 340, 41);
        panel.add(submitAnswer);
        submitAnswer.setOpaque(false);
        submitAnswer.setForeground(Color.BLACK);
        submitAnswer.setContentAreaFilled(false);
        submitAnswer.setBorderPainted(false);
       
        
        //Declaring submitrAnswer + results butrtons. Easier to do them in one giant try-catch so that we don't have to write a new try catch for each button to make the font wor
		try{
	           Font font = Font.createFont(Font.TRUETYPE_FONT, grade3OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
	           submitAnswer.setFont(font.deriveFont(Font.BOLD, 30f));
	           submitAnswer5.setVisible(false);
	           submitAnswer5.setHideActionText(true);
	           submitAnswer5.setOpaque(false);
	           submitAnswer5.setForeground(Color.BLACK);
	           submitAnswer5.setContentAreaFilled(false);
	           submitAnswer5.setBorderPainted(false);
	           submitAnswer5.setBounds(158, 231, 345, 41);
	           submitAnswer5.setFont(font.deriveFont(Font.BOLD, 30f));
	           panel.add(submitAnswer5);
	           submitAnswer4.setVisible(false);
	           submitAnswer4.setOpaque(false);
	           submitAnswer4.setForeground(Color.BLACK);
	           submitAnswer4.setContentAreaFilled(false);
	           submitAnswer4.setBorderPainted(false);
	           submitAnswer4.setBounds(158, 231, 345, 41);
	           submitAnswer4.setFont(font.deriveFont(Font.BOLD, 30f));
	           panel.add(submitAnswer4);
	           submitAnswer3.setVisible(false);
	           submitAnswer3.setOpaque(false);
	           submitAnswer3.setForeground(Color.BLACK);
	           submitAnswer3.setContentAreaFilled(false);
	           submitAnswer3.setBorderPainted(false);
	           submitAnswer3.setBounds(158, 231, 345, 41);
	           submitAnswer3.setFont(font.deriveFont(Font.BOLD, 30f));
	           panel.add(submitAnswer3);
	           submitAnswer2.setVisible(false);
	           submitAnswer2.setOpaque(false);
	           submitAnswer2.setForeground(Color.BLACK);
	           submitAnswer2.setContentAreaFilled(false);
	           submitAnswer2.setBorderPainted(false);
	           submitAnswer2.setBounds(158, 231, 345, 41);
	           submitAnswer2.setFont(font.deriveFont(Font.BOLD, 30f));
	           panel.add(submitAnswer2);
	           
	           resultsBut = new JButton("VIEW RESULTS");
	           resultsBut.setVisible(false);
	           resultsBut.setFont(font.deriveFont(Font.BOLD, 30f));
	           resultsBut.setOpaque(false);
	           resultsBut.setForeground(Color.BLACK);
	           resultsBut.setContentAreaFilled(false);
	           resultsBut.setBorderPainted(false);
	           resultsBut.setBounds(158, 105, 340, 41);
	           panel.add(resultsBut);
	           
	           
	           maybe.setVisible(false);
	           maybe.setBounds(44, 316, 100, 46);
	           panel.add(maybe);
	           returntoResults.setVisible(false);
	           returntoResults.setOpaque(false);
	           returntoResults.setForeground(Color.BLACK);
	           returntoResults.setContentAreaFilled(false);
	           returntoResults.setBorderPainted(false);
	           returntoResults.setBounds(79, 267, 542, 41);
	           returntoResults.setFont(font.deriveFont(Font.BOLD, 30f));
	           
	           
	           
	           panel.add(returntoResults);
	           resultsTitle.setEditable(false);
	           resultsTitle.setVisible(false);
	           resultsTitle.setBounds(10, 317, 670, 52);
	           resultsTitle.setForeground(new Color(48, 126, 143));
		       resultsTitle.setFont(font.deriveFont(Font.BOLD, 15f));
		     
	           
	           panel.add(resultsTitle);
	           grade.setVisible(false);
	           grade.setFont(font.deriveFont(Font.BOLD, 30f));
	           grade.setBounds(484, 67, 145, 52);
	           
	           panel.add(grade);
	           
	          
	   
	         
	          
	       }
		catch(Exception e){}
		
		returntoResults.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				returntoResults.setForeground(new Color(48, 126, 143));

			}
		});
		returntoResults.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				returntoResults.setForeground(new Color(0, 0, 0));
			}
		});
		

		//these mouse listener methods just control the hover effect of all of the submit answer buttons. 
		submitAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				submitAnswer.setForeground(new Color(48, 126, 143));

			}
		});
		submitAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				submitAnswer.setForeground(new Color(0, 0, 0));
			}
		});
		
		
		submitAnswer2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				submitAnswer2.setForeground(new Color(48, 126, 143));

			}
		});
		submitAnswer2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				submitAnswer2.setForeground(new Color(0, 0, 0));
			}
		});
		
		submitAnswer3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				submitAnswer3.setForeground(new Color(48, 126, 143));

			}
		});
		submitAnswer3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				submitAnswer3.setForeground(new Color(0, 0, 0));
			}
		});
		
		
		submitAnswer4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				submitAnswer4.setForeground(new Color(48, 126, 143));

			}
		});
		submitAnswer4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				submitAnswer4.setForeground(new Color(0, 0, 0));
			}
		});
		
		submitAnswer5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				submitAnswer5.setForeground(new Color(48, 126, 143));

			}
		});
		submitAnswer5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				submitAnswer5.setForeground(new Color(0, 0, 0));
			}
		});
		
		resultsBut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				resultsBut.setForeground(new Color(48, 126, 143));

			}
		});
		resultsBut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				resultsBut.setForeground(new Color(0, 0, 0));
			}
		});
		
		JTextPane warningMessage = new JTextPane();
		warningMessage.setBackground(new Color(0,0,0,0));
		warningMessage.setEditable(false);
		warningMessage.setContentType("text/html");
		warningMessage.setText("Make sure you have completed the unit test and reviewed your results before navigating away from this page! <p> Navigating away before the unit test is complete means your answers may not be saved! "
				+ "<p> Clicking any button on the sidebar again will quit this test.");
		
		warningMessage.setFont(new Font("Calibri", Font.BOLD, 18));
		homebut.setText("Home");
		

		homebut.setFont(new Font("Calibri", Font.PLAIN, 30));
		homebut.setForeground(new Color(255, 255, 255));
		homebut.setBackground(new Color(48, 126, 143));
		homebut.setOpaque(false);
		homebut.setIcon(new ImageIcon(getClass().getResource("Images/home.png")));
		homebut.setRolloverEnabled(true);
		homebut.setContentAreaFilled(false);
		homebut.setBorderPainted(false);
		getContentPane().add(homebut);
		homebut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				homebut.setForeground(new Color(255, 127, 80));

			}
		});
		homebut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				homebut.setForeground(new Color(255, 255, 255));
			}
		});

		
		homebut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
			
				
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					homepagev2 homepagev2 = new homepagev2();
					homepagev2.setVisible(true);
					setVisible(false);//close this page
					
				}
			
		    	

			}
		});

		profilebut.setText("My Profile");

		profilebut.setForeground(new Color(255, 255, 255));
		profilebut.setBackground(new Color(48, 126, 143));
		profilebut.setOpaque(false);
		profilebut.setIcon(new ImageIcon(getClass().getResource("Images/hcprofile.png")));
		profilebut.setFont(new Font("Calibri", Font.PLAIN, 30));
		profilebut.setContentAreaFilled(false);
		profilebut.setBorderPainted(false);
		
		profilebut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				profilebut.setForeground(new Color(255, 127, 80));
			}
		});

		profilebut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				profilebut.setForeground(new Color(255, 255, 255));
			}
		});
		clicked = 0; //resetting clicked variable to 0
		profilebut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				
				
				 //resetting click variable
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					Profile Profile = new Profile();
					Profile.setVisible(true);
					setVisible(false);//close this page
					
				}
			
		    	

			}
		});

		getContentPane().add(profilebut);

		progressbut.setText("My Progress");
		progressbut.setForeground(new Color(255, 255, 255));
		progressbut.setBackground(new Color(48, 126, 143));
		progressbut.setOpaque(false);
		progressbut.setIcon(new ImageIcon(getClass().getResource("Images/progress.png")));
		progressbut.setFont(new Font("Calibri", Font.PLAIN, 30));
		progressbut.setContentAreaFilled(false);
		progressbut.setBorderPainted(false);
		getContentPane().add(progressbut);
		
		progressbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				progressbut.setForeground(new Color(255, 127, 80));
			}
		});

		progressbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				progressbut.setForeground(new Color(255, 255, 255));
			}
		});
		clicked = 0;
		progressbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				
				
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					Profile Profile = new Profile();
					Profile.setVisible(true);
					setVisible(false);//close this page
					
				}
			
		    	

			}
		});

		clicked = 0;

		classbut.setText("Recordings");
		classbut.setForeground(new Color(255, 255, 255));
		classbut.setBackground(new Color(48, 126, 143));
		classbut.setOpaque(false);
		classbut.setIcon(new ImageIcon(getClass().getResource("Images/class.png")));
		classbut.setFont(new Font("Calibri", Font.PLAIN, 30));
		classbut.setContentAreaFilled(false);
		classbut.setBorderPainted(false);
		getContentPane().add(classbut);
		
		classbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				classbut.setForeground(new Color(255, 127, 80));
			}
		});

		classbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				classbut.setForeground(new Color(255, 255, 255));
			}
		});
		
		classbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					Profile Profile = new Profile();
					Profile.setVisible(true);
					setVisible(false);//close this page
					
				}
			
		    	

			}
		});

		clicked = 0;
		
		unitbut.setText("Units");
		unitbut.setForeground(new Color(255, 255, 255));
		unitbut.setBackground(new Color(48, 126, 143));
		unitbut.setOpaque(false);
		unitbut.setIcon(new ImageIcon(getClass().getResource("Images/units.png")));
		unitbut.setFont(new Font("Calibri", Font.PLAIN, 30));
		unitbut.setContentAreaFilled(false);
		unitbut.setBorderPainted(false);
		getContentPane().add(unitbut);
		
		unitbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				unitbut.setForeground(new Color(255, 127, 80));
			}
		});

		unitbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				unitbut.setForeground(new Color(255, 255, 255));
			}
		});
		
		unitbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
			
				
				
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(unitselectunittestgthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(unitselectunittestgthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(unitselectunittestgthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(unitselectunittestgthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					unitselectunittestgthree unitselectunittestgthree  = new unitselectunittestgthree();
					unitselectunittestgthree.setVisible(true);
					setVisible(false);//close this page
					
				}
			
		    	

			}
		});

		clicked = 0;
		
		rewardsbut.setText("Rewards");
		rewardsbut.setForeground(new Color(255, 255, 255));
		rewardsbut.setBackground(new Color(48, 126, 143));
		rewardsbut.setOpaque(false);
		rewardsbut.setIcon(new ImageIcon(getClass().getResource("Images/reward.png")));
		rewardsbut.setFont(new Font("Calibri", Font.PLAIN, 30));
		rewardsbut.setContentAreaFilled(false);
		rewardsbut.setBorderPainted(false);
		getContentPane().add(rewardsbut);
		
		rewardsbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				rewardsbut.setForeground(new Color(255, 127, 80));
			}
		});

		rewardsbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				rewardsbut.setForeground(new Color(255, 255, 255));
			}
		});
		
		rewardsbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {

				
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					Profile Profile = new Profile();
					Profile.setVisible(true);
					setVisible(false);//close this page
					
				}
			
		    	

			}
		});

		helpbut.setText("Need Help? ");
		helpbut.setForeground(new Color(255, 255, 255));
		helpbut.setBackground(new Color(48, 126, 143));
		helpbut.setOpaque(false);
		helpbut.setIcon(new ImageIcon(getClass().getResource("Images/question.png")));
		helpbut.setFont(new Font("Calibri", Font.PLAIN, 30));
		helpbut.setContentAreaFilled(false);
		helpbut.setBorderPainted(false);
		getContentPane().add(helpbut);
		
		helpbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				helpbut.setForeground(new Color(255, 127, 80));
			}
		});

		helpbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				helpbut.setForeground(new Color(255, 255, 255));
			}
		});
		
		helpbut.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				
				clicked = 0; //resetting click variable
				clicked++; //incrementing click variable
				if (clicked == 1) //if the user clicks the button once, the dialog box gets displayed
				{
					JOptionPane.showMessageDialog(null,warningMessage,"Wait!",JOptionPane.ERROR_MESSAGE);
				}
				else if (clicked > 1) //if the user clicks it more than once, the relevant page gets opened
				{
					try {
						for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
						}
					} catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Morehelp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Morehelp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Morehelp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Morehelp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
					}
					Morehelp Morehelp = new Morehelp();
					Morehelp.setVisible(true);
					setVisible(false);//close this page
				}
			
		    	

			}
		});

		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBackground(new Color(65, 158, 178));
		header.setText("Unit 1: Test 1 ");
		header.setFont(new Font("Roboto", Font.BOLD, 30));
		header.setForeground(new Color(255, 255, 255));
		header.setBorder(null);
		getContentPane().add(header);

		numcrunch.setText("Number");

		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT,
					grade3OATUnitTestEasy.class.getResourceAsStream("MPLUSRounded1c-black.ttf"));
			numcrunch.setFont(font.deriveFont(Font.BOLD, 35f));
		} catch (Exception e) {
		}

		numcrunch.setForeground(new Color(255, 255, 255));
		getContentPane().add(numcrunch);

		label_1 = new JLabel();
		label_1.setBounds(25, 51, 225, 60);
		label_1.setText("Crunchers");
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT,
					grade3OATUnitTestEasy.class.getResourceAsStream("MPLUSRounded1c-black.ttf"));
			label_1.setFont(font.deriveFont(Font.BOLD, 35f));
		} catch (Exception e) {
		}
		label_1.setForeground(Color.WHITE);
		getContentPane().add(label_1);

		sidebar.setBackground(new Color(48, 126, 143));
		getContentPane().add(sidebar);
		getContentPane().add(back);
		back.setIcon(new ImageIcon(getClass().getResource("Images/background.jpg")));
		

		pack();
	          }

	
	//Overview of how this test functions:
//There are 5 questions

//There are 5 submitAnswer buttons, 5 hint buttons, 5 arrow buttons (these are buttonA, buttonB, buttonC, buttonD, and buttonF), and there are 5 text fields that read input from the user. These text fields are textAnswer, questionB, questionC, questionD, and questionE
//All 5 submitAnswer buttons are stacked on top of each other, all 5 hint buttons are stacked on top of each other, all 5 arrow buttons are stacked on top of each other, and all 5 text fields are stacked on top of each other
//Only one of each is visible at a time	
//Once the user clicks a submitAnswer button, that current button will be made invisible, the current text field will be disabled (meaning it can't be edited), and an arrow button will trigger
//Once the user clicks the arrow, that current arrow button and the current text field will be made invisible, and the next submitAnswer button and text field will trigger
//The user can manually call for a hint by selecting the question mark icon. This will not affect their score.
//If the user enters a correct answer in 3 times, the correct answer in addition to an explanation will pop up. This occurring will mark the question as incorrect.
//This repeats until the test is complete
//Once the test finishes, the user will be able to click a button (called resultsBut) to display the results
//This button sets the visibility of the 5 text fields from each question to true, and resizes + repositions them neatly so the user can view the answers that they entered into each text field in the order that they answered them
//Eventually the questions, in addition to an indication of which answers they received credit for, will be placed alongside the answer text fields

//Randomization is modulated by a method called randomFill(), which creates a range of numbers between a minimum and maximum value, which are specified when the method is called
//There are three variables, i, j, k which are initiated with a random number via randomFill(), and are then used to populate the string arrays questions[] and answer[]
//These arrays contain the mathematical operators used to make different problem types, and each element in questions[] represents a different question type 
//Elements from the answer[] array are compared with the user's input to determine a correct answer
//The order of the questions is not random, but the values always are

//Kind of a crude implementation but it works and it's flexible
	
	//method to generate the test
	public void shortAnswerTestGenerator()
	{
	         //Variables declared to store the random numbers for each test. Selects a number between 1 and 10 and randomizes it via randomFill(). These parameters are what we'll adjust when we want to scale tests up for different grade levels.
		 int i = randomFill(1, 10);
         int j = randomFill(1, 10);
         int k = randomFill(1, 10);
         int x = randomFill(7, 9);
         int y = randomFill(3, 5); //These last two variables are specifically for one type of addition problem that requires the two numbers to be less than 10, but produce a sum greater than 10
         
         
         //My attempt at making the word problem premise sort of random. You can delete these for numbers and operations in base 10.
         String[] wordProblems = {"Alex is making sandwiches. "
         		+ " If he has ", "Janice is baking cupcakes. If she has ", "Janet is making sandwiches. If she has ", "Jason is baking cupcakes. If he has "};
         
         Collections.shuffle(Arrays.asList(wordProblems));
 
	      
		          //Question array. i, j, and k are substituted for real numbers. While the values of i, j, and k will be shuffled each time the test is run, those numbers will not be randomized again at any point during the test.
         		  //To get around this, I've added a number to the random value that gets generated (ex. k+1) or multiplied by 2 occasionally to ensure that each question has different numbers.
         		  //Question order is multiplication word problem, subtraction, division (this question is currently set to i*2/2 to ensure that i is always even and that the answer is never a decimal), addition, and a yes/no question.
		      	String[] questions = 	{wordProblems[0] + i + " colleagues coming over and made " + j + " for each of them, how many were made?", 
		      			"Solve: " + (j+1) + " - " + k, "If " + i + " x " + " 2 = " + i*2 + ", then " + i*2 + "/" + 2 + " must be: ", 
		      			"Use the making a 10 method (if applicable) to solve: " + x + " + " + y, "Should " + (j*2) + " x " + (i*2) + " give the same answer as " + (i*2) + " x " + (j*2) + "? Enter yes or no."};
		      	
		      	//Array that holds the answers. Was originally an int array but changed it to String for ease of use when we do geometry questions that require text answers.
		      	//Each element corresponds to the proper formula for w/e the type of problem it is. If I added a number to them (ex. k+1) in the question array, that is reflected here as well
		      	String[] answer = {""+(i*j), ""+((j+1)-k),""+(i*2/2), "" + (x+y), "Yes"};
			     
			  
			      	 
			      	
			      
					
		//beginTest is the button the user clicks to begin the test
		beginTest.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				index = 0; 
				textArea5.setFont(new Font("Calibri", Font.BOLD, 19));
				instructionLabel.setVisible(false);
				textField1.setText("Question "+(index+1)+"/" + (total_questions)); //textField1 is the text field that displays what question the user is on compared to how many they have left.
				textArea5.setVisible(true);//textArea5 is the text area that displays the question that's being asked.
				textArea5.setText(questions[0]); //this statement populates textArea5 with the first element of the question array
				textAnswer.setVisible(true); //textAnswer is the first of 5 text fields that are used to receive the user's answer
				beginTest.setVisible(false); //once the user clicks the beginTest button, its visibility is set to false so that it's no longer on the screen
				submitAnswer.setVisible(true); //when the user clicks beginTest, the first submitAnswer button will be made visible
			
				
				
				
				
			}
		});
		
		//These two mouse listeners handle beginTest's button hover effect
		beginTest.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				beginTest.setForeground(new Color(48, 126, 143)); //When beginTest is hovered, its color will change

			}
		});
		beginTest.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				beginTest.setForeground(new Color(0, 0, 0)); //When beginTest is no longer being hovered, its color will change back to what it was originally
			}
		});
		
		
			//The first of five mouse listeners used to process answer submissions
			submitAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					try{
			      		String userAnswer = textAnswer.getText();  //Storing the number that the user types into the text field in a variable called userAnswer

			      		if (userAnswer.equals(answer[0]) || userAnswer.equals(" " + answer[0])) { //comparing userAnswser (which stores what the user typed in) to the first element of the answer array.
			      		
							correctAnswer.setVisible(true); //if the answer is correct, the jlabel containing the massive green checkmark gets displayed
							incorrectAnswer.setVisible(false); 
							buttonA.setVisible(true); //The first arrow button becomes visible
							submitAnswer.setVisible(false); //Current subtmitAnswer button disappears
							correctInWords.setVisible(true);
							textAnswer.setDisabledTextColor(new Color(34, 139, 34)); //setting the color of the disabled text field to green if the answer was correct
							correctInWords.setText("CORRECT!"); //setting text area to display "CORRECT" in text
							correctInWords.setForeground(new Color(0,128,0)); //setting that text to a green color
							textAnswer.setEnabled(false); //Statement to disable the text field to prevent multiple answers from being submitted							
				      		correct_guesses++; //each time the user gets a correct answer, the correct_guesses variable will increment by one. Total number of correct_guesses divided by total questions is their score

							
			      	} 
			      		
			      		else //if the user is incorrect
						{
			      			
			      			correctAnswer.setVisible(false);
							incorrectAnswer.setVisible(true); //jlabel containing red x gets displayed if the user is incorrect
							////Current subtmitAnswer button disappears
						
						
								JOptionPane.showMessageDialog(panel, "The correct answer is " + answer[0] + "!"); //Edit this dialog box to edit the auto hint. Again, you don't have to use the random number variables if you don't want to and can make the hint whatever you want.
								textAnswer.setEnabled(false); //Statement to disable the text field to prevent multiple answers from being submitted
								buttonA.setVisible(true);//The first arrow button gets made visible
								correctInWords.setVisible(true);
								correctInWords.setText("INCORRECT!");
								textAnswer.setDisabledTextColor(new Color(255, 0, 0)); //If the auto hint triggers, the question is marked incorrect. Therefore correct_guesses is not incremented and the text color of the disabled text field is set to red.
								correctInWords.setForeground(new Color(65, 0, 0));
								submitAnswer.setVisible(false);

						}
			      		
			      		
					}catch(NumberFormatException ex){ 
			      	    
			      	}
					
					
					
				
					}
				});
				
			
			
			//This mouse listener, along with all subsequent arrow button mouse listeners (buttons A-D + F), does exactly what the beginTest mouse listener did. 
			//Re-populates the text field displaying the question with the next element in the questions array, sets the next submitAnswer's visibility to true, the next text field for receiving the user's answer's visibility to true, etc
			buttonA.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					index = 1;
					
					
					textField1.setText("Question "+(index+1)+"/" + (total_questions));
					textArea5.setText(questions[1]);
					textArea5.setFont(new Font("Calibri", Font.BOLD, 25));
					
					textArea5.setBounds(188, 91, 274, 63); //This line and the next line reset the bounds of the field that display the question and the correct/incorrect text because they were adjusted to fit the word problem
					correctInWords.setBounds(205, 222, 274, 50);
					
					textAnswer.setVisible(false); //previous text field that read answer from the user is made invisible
					submitAnswer2.setVisible(true);
					questionB.setVisible(true); //this is the new text field that replaces textAnswer
					correctAnswer.setVisible(false);
					incorrectAnswer.setVisible(false);	
					correctInWords.setVisible(false);
					buttonA.setVisible(false);
					
				
					
					
					
				}
			});
			
			submitAnswer2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					
					
					try{
			      		String userAnswer = (questionB.getText()); 
			      		if (userAnswer.equals(answer[1]) || userAnswer.equals(" " + answer[1])) {
							
							correctAnswer.setVisible(true);
							incorrectAnswer.setVisible(false);
							buttonB.setVisible(true);
							submitAnswer2.setVisible(false);
							correctInWords.setVisible(true);
							questionB.setDisabledTextColor(new Color(34, 139, 34));
							correctInWords.setText("CORRECT!");
							correctInWords.setForeground(new Color(0,128,0));
							questionB.setEnabled(false);
							correct_guesses++;
							
			      	} 
			      		
			      		else
						{
			      			
			      			correctAnswer.setVisible(false);
							incorrectAnswer.setVisible(true);
					
							JOptionPane.showMessageDialog(panel, "The correct answer is " + answer[1] +  "!");
						
							submitAnswer2.setVisible(false);
							buttonB.setVisible(true);
							questionB.setEnabled(false);
							questionB.setDisabledTextColor(new Color(255, 0, 0));
							correctInWords.setVisible(true);
							correctInWords.setText("INCORRECT!");
							correctInWords.setForeground(new Color(65, 0, 0));
									
						
						
						}
					}catch(NumberFormatException ex){ 
			      	    
			      	}

					}
				});
		
			buttonB.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					index = 2;
					textField1.setText("Question "+(index+1)+"/" + (total_questions));
					textArea5.setText(questions[2]);
					textArea5.setFont(new Font("Calibri", Font.BOLD, 20));
					
				
					questionB.setVisible(false);
					submitAnswer3.setVisible(true);
					questionC.setVisible(true);
					correctAnswer.setVisible(false);
					incorrectAnswer.setVisible(false);	
					correctInWords.setVisible(false);
					buttonB.setVisible(false);
					
				
				}
				});
			
			submitAnswer3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					try{
			      		String userAnswer = (questionC.getText()); 
			      		if (userAnswer.equalsIgnoreCase(answer[2]) || userAnswer.equalsIgnoreCase(" " + answer[2]))  {
							
							correctAnswer.setVisible(true);
							incorrectAnswer.setVisible(false);
							buttonC.setVisible(true);
							questionC.setDisabledTextColor(new Color(34, 139, 34));
							submitAnswer3.setVisible(false);
							correctInWords.setVisible(true);
							correctInWords.setText("CORRECT!");
							correctInWords.setForeground(new Color(0,128,0));
							questionC.setEnabled(false);
							
							correct_guesses++;
							
							
							
			      	} 
			      		
			      		else
						{
			   
			      			correctAnswer.setVisible(false);
							incorrectAnswer.setVisible(true);
							
			
							JOptionPane.showMessageDialog(panel, "The correct answer is " + answer[2] + "!");
							submitAnswer3.setVisible(false);
							buttonC.setVisible(true);
							questionC.setDisabledTextColor(new Color(255, 0, 0));
							questionC.setEnabled(false);
							correctInWords.setVisible(true);
							correctInWords.setText("INCORRECT!");
							correctInWords.setForeground(new Color(65, 0, 0));
									
						
						
						
						}
					}catch(NumberFormatException ex){ 
			      	    
			      	}
					
					
					
				
					}
				});
			
			buttonC.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					index = 3;
					textField1.setText("Question "+(index+1)+"/" + (total_questions));
					
					textArea5.setText(questions[3]);
					textArea5.setBounds(188, 91, 274, 100 );
					textArea5.setFont(new Font("Calibri", Font.BOLD, 25));
					questionD.setBounds(183, 192, 274, 63);
					submitAnswer4.setBounds(153, 266, 340, 41);
					correctInWords.setBounds(193, 266, 274, 50);
				
					
					questionC.setVisible(false);
					submitAnswer4.setVisible(true);
					questionD.setVisible(true);
					correctAnswer.setVisible(false);
					incorrectAnswer.setVisible(false);	
					correctInWords.setVisible(false);
					buttonC.setVisible(false);
					
		
				}
				});
			
			submitAnswer4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					try{
			      		String userAnswer = (questionD.getText()); 
			      		if (userAnswer.equals(answer[3]) || userAnswer.equals(" " + answer[3])){
							
							correctAnswer.setVisible(true);
							incorrectAnswer.setVisible(false);
							buttonD.setVisible(true);
							submitAnswer4.setVisible(false);
							correctInWords.setVisible(true);
							questionD.setDisabledTextColor(new Color(34, 139, 34));
							correctInWords.setText("CORRECT!");
							correctInWords.setForeground(new Color(0,128,0));
							questionD.setEnabled(false);
							correct_guesses++;
							
							
							
			      	} 
			      		
			      		else
						{
			      			
			      			correctAnswer.setVisible(false);
							incorrectAnswer.setVisible(true);
							
				
							JOptionPane.showMessageDialog(panel, "The correct answer is " + answer[3] + "!");
							submitAnswer4.setVisible(false);
							questionD.setDisabledTextColor(new Color(255, 0, 0));
							buttonD.setVisible(true);
							questionD.setEnabled(false);
							correctInWords.setVisible(true);
							correctInWords.setText("INCORRECT!");
							correctInWords.setForeground(new Color(65, 0, 0));
									
						
						
						
						}
					}catch(NumberFormatException ex){ 
			      	    
			      	}
					
					
					
					
				
					}
				});
			buttonD.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					index = 4;
					textField1.setText("Question "+(index+1)+"/" + (total_questions));
					textArea5.setText(questions[4]);
					
				
					textArea5.setBounds(188, 91, 274, 100 );
					
					textArea5.setFont(new Font("Calibri", Font.BOLD, 25));
					questionE.setBounds(183, 192, 274, 63); //Adjusting the locations text field, submit answer button, and the correct/incorrect text label to account for how much space the question takes up
					submitAnswer5.setBounds(153, 266, 340, 41);
					correctInWords.setBounds(193, 266, 274, 50);
					
					questionD.setVisible(false);
					questionE.setVisible(true);
					submitAnswer5.setVisible(true);
					correctAnswer.setVisible(false);
					incorrectAnswer.setVisible(false);	
					correctInWords.setVisible(false);
					buttonD.setVisible(false);
					
				
				}
				});
			
			submitAnswer5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					try{
			      		String userAnswer = (questionE.getText()); 
			      		if (userAnswer.equalsIgnoreCase(answer[4]) || userAnswer.equalsIgnoreCase(" " + answer[4])) {
							
							correctAnswer.setVisible(true);
							incorrectAnswer.setVisible(false);
							buttonF.setVisible(true);
							submitAnswer5.setVisible(false);
							questionE.setDisabledTextColor(new Color(34, 139, 34));
							correctInWords.setVisible(true);
							correctInWords.setText("CORRECT!");
							correctInWords.setForeground(new Color(0,128,0));
							questionE.setEnabled(false);
							correct_guesses++;
							
							
							
			      	} 
			      		
			      		else
						{
			      			
			      			correctAnswer.setVisible(false);
							incorrectAnswer.setVisible(true);
							
							JOptionPane.showMessageDialog(panel, "The correct answer is " + answer[4] + "!");
							submitAnswer5.setVisible(false);
							buttonF.setVisible(true);
							questionE.setDisabledTextColor(new Color(255, 0, 0));
							questionE.setEnabled(false);
							correctInWords.setVisible(true);
							correctInWords.setText("INCORRECT!");
							correctInWords.setForeground(new Color(65, 0, 0));
									
						
						
						
						}
					}catch(NumberFormatException ex){ 
			      	    
			      	}
					
					
					
					
				
					}
				});
			
			buttonF.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent evt) {
					
					
					
					
				
					textField1.setText("TEST COMPLETE");
					
					textArea5.setVisible(false);
					questionD.setVisible(false);
					questionE.setVisible(false);
					submitAnswer5.setVisible(false);
					correctAnswer.setVisible(false);
					incorrectAnswer.setVisible(false);	
					correctInWords.setVisible(false);
					buttonF.setVisible(false);
					resultsBut.setVisible(true);
					
					
				//beginning of the results display section. You shouldn't have to edit any of this at all and can keep it as is for all tests. You may need to adjust the bounds for textAre5 so that the full question displays on screen, but that should be it.
				//Displays grade as a percentage and as a result out of the total number of questions.
				//Users can select 1 of the 5 question buttons to return to that question and view what their answer was
					resultsBut.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mousePressed(java.awt.event.MouseEvent evt) {
							
							JLabel correctAnswer1 = new JLabel(); //creates text label that displays the correct answer above the user's answer when a user clicks on a question they want to review
							correctAnswer1.setBounds(190, 28, 325, 50);
							panel.add(correctAnswer1);
							correctAnswer1.setForeground(new Color(0,128,0));
							correctAnswer1.setVisible(false);
							
							try{
						           Font font = Font.createFont(Font.TRUETYPE_FONT, grade4OATUnitTestEasy.class.getResourceAsStream("Bungee-Regular.ttf"));
						           correctAnswer1.setFont(font.deriveFont(Font.BOLD, 20f));
						          

						       }
							catch(Exception e){}
							resultsTitle.setVisible(true);
							grade.setVisible(true);
							
							resultsTitle.setText("RESULTS! CLICK THE QUESTION BUTTONS TO DISPLAY THE QUESTION AND YOUR ANSWER!");
							question1.setText("QUESTION 1:"); //These 5 buttons just label the question on the results page.
							question2.setText("QUESTION 2:");
							question3.setText("QUESTION 3:");
							question4.setText("QUESTION 4:");
							question5.setText("QUESTION 5:");
							
							
							question1.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
									question1.setForeground(new Color(48, 126, 143));

								}
							});
							question1.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseExited(java.awt.event.MouseEvent evt) {
									question1.setForeground(new Color(0, 0, 0));
								}
							});
							
							question2.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
									question2.setForeground(new Color(48, 126, 143));

								}
							});
							question2.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseExited(java.awt.event.MouseEvent evt) {
									question2.setForeground(new Color(0, 0, 0));
								}
							});
							
							question3.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
									question3.setForeground(new Color(48, 126, 143));

								}
							});
							question3.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseExited(java.awt.event.MouseEvent evt) {
									question3.setForeground(new Color(0, 0, 0));
								}
							});
							
							question4.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
									question4.setForeground(new Color(48, 126, 143));

								}
							});
							question4.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseExited(java.awt.event.MouseEvent evt) {
									question4.setForeground(new Color(0, 0, 0));
								}
							});
							
							question5.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseEntered(java.awt.event.MouseEvent evt) {
									question5.setForeground(new Color(48, 126, 143));

								}
							});
							question5.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mouseExited(java.awt.event.MouseEvent evt) {
									question5.setForeground(new Color(0, 0, 0));
								}
							});
							
							
							question1.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mousePressed(java.awt.event.MouseEvent evt) {
									textAnswer.setBounds(183, 192, 274, 63);
									textArea5.setVisible(true);
									textArea5.setText(questions[0]);
									textArea5.setBounds(188, 91, 274, 99);
									textArea5.setFont(new Font("Calibri", Font.BOLD, 19));
									
									correctAnswer1.setVisible(true);
								
									
									correctAnswer1.setText("Correct anwser: " + answer[0]);
									
									question1.setVisible(false); 
									question2.setVisible(false);
									question3.setVisible(false);
									question4.setVisible(false);
									question5.setVisible(false);
								
									textField1.setVisible(false);
									resultsBut.setVisible(false);
									
									questionB.setVisible(false);
								
									
									questionC.setVisible(false);
									
									
									questionD.setVisible(false);
									
									
									questionE.setVisible(false);
									
									returntoResults.setVisible(true);
									
									returntoResults.setBounds(79, 267, 542, 41);

								}
							});
							
							returntoResults.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mousePressed(java.awt.event.MouseEvent evt) {
									question1.setVisible(true); //Making those buttons visible
									question2.setVisible(true);
									question3.setVisible(true);
									question4.setVisible(true);
									question5.setVisible(true);
									textArea5.setVisible(false);
									textAnswer.setVisible(true);
									textAnswer.setBounds(248, 67, 136, 27);
									
									correctAnswer1.setVisible(false);
									
									questionB.setVisible(true);
									questionB.setBounds(248, 117, 136, 27);
									
									questionC.setVisible(true);
									questionC.setBounds(248, 167, 136, 27);
									
									questionD.setVisible(true);
									questionD.setBounds(248, 217, 136, 27);
									
									questionE.setVisible(true);
									questionE.setBounds(248, 267, 136, 27);
									returntoResults.setVisible(false);
								
									
									
								}
							});
							
							question2.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mousePressed(java.awt.event.MouseEvent evt) {
									
									textArea5.setVisible(true);
									textArea5.setText(questions[1]);
									textArea5.setBounds(188, 91, 274, 63); //This line and the next line reset the bounds of the field that display the question and the correct/incorrect text because they were adjusted to fit the word problem
									
									textArea5.setFont(new Font("Calibri", Font.BOLD, 16));
									
									question1.setVisible(false); //Making those buttons visible
									question2.setVisible(false);
									question3.setVisible(false);
									question4.setVisible(false);
									question5.setVisible(false);
									
									correctAnswer1.setVisible(true);
								
									
									correctAnswer1.setText("Correct anwser: " + answer[1]);
									
									returntoResults.setBounds(79, 240, 542, 41);
								
									textField1.setVisible(false);
									resultsBut.setVisible(false);
									textAnswer.setVisible(false);
									
									questionB.setVisible(true);
									questionB.setBounds(188, 157, 274, 63);
									
									questionC.setVisible(false);
									
									
									questionD.setVisible(false);
									
									
									questionE.setVisible(false);
									
									returntoResults.setVisible(true);

								}
							});
							
							
							question3.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mousePressed(java.awt.event.MouseEvent evt) {
									
									textArea5.setVisible(true);
									textArea5.setText(questions[2]);
									textArea5.setBounds(188, 91, 274, 63); 
									
									textArea5.setFont(new Font("Calibri", Font.BOLD, 16));
									
									question1.setVisible(false); 
									question2.setVisible(false);
									question3.setVisible(false);
									question4.setVisible(false);
									question5.setVisible(false);
									
									correctAnswer1.setVisible(true);
								
									
									correctAnswer1.setText("Correct anwser: " + answer[2]);
								
									textField1.setVisible(false);
									resultsBut.setVisible(false);
									textAnswer.setVisible(false);
									
									questionB.setVisible(false);
									
									
									questionC.setVisible(true);
									questionC.setBounds(188, 157, 274, 63);
									
									questionD.setVisible(false);
									
									returntoResults.setBounds(79, 240, 542, 41);
									
									questionE.setVisible(false);
									
									returntoResults.setVisible(true);

								}
							});
							
							
							question4.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mousePressed(java.awt.event.MouseEvent evt) {
									
									textArea5.setVisible(true);
									textArea5.setText(questions[3]);
									
									
									textArea5.setFont(new Font("Calibri", Font.BOLD, 16));
									
									correctAnswer1.setVisible(true);
								
									
									correctAnswer1.setText("Correct anwser: " + answer[3]);
									
									question1.setVisible(false); 
									question2.setVisible(false);
									question3.setVisible(false);
									question4.setVisible(false);
									question5.setVisible(false);
								
									textField1.setVisible(false);
									resultsBut.setVisible(false);
									textAnswer.setVisible(false);
									
									questionB.setVisible(false);
									
									
									questionC.setVisible(false);
									
									
									questionD.setVisible(true);
									questionD.setBounds(183, 192, 274, 63);;
									
									returntoResults.setBounds(79, 267, 542, 41);
									
									
									questionE.setVisible(false);
									
									returntoResults.setVisible(true);

								}
							});
							
							
							question5.addMouseListener(new java.awt.event.MouseAdapter() {
								public void mousePressed(java.awt.event.MouseEvent evt) {
									
									textArea5.setVisible(true);
									textArea5.setText(questions[4]);
									
									
									textArea5.setFont(new Font("Calibri", Font.BOLD, 25));
									
									correctAnswer1.setVisible(true);
								
									
									correctAnswer1.setText("Correct anwser: " + answer[4]);
									
									question1.setVisible(false); //Making those buttons visible
									question2.setVisible(false);
									question3.setVisible(false);
									question4.setVisible(false);
									question5.setVisible(false);
								
									textField1.setVisible(false);
									resultsBut.setVisible(false);
									textAnswer.setVisible(false);
									
									questionB.setVisible(false);
									
									
									questionC.setVisible(false);
									
									
									questionD.setVisible(false);
									
									questionE.setVisible(true);
									questionE.setBounds(183, 192, 274, 63);
									
									returntoResults.setVisible(true);
									
									returntoResults.setBounds(79, 267, 542, 41);

								}
							});
							
							
							question1.setVisible(true); //Making those buttons visible
							question2.setVisible(true);
							question3.setVisible(true);
							question4.setVisible(true);
							question5.setVisible(true);
						
							textField1.setVisible(false);
							resultsBut.setVisible(false);
							
							
							textAnswer.setVisible(true);
							textAnswer.setBounds(248, 67, 136, 27);
							
							
							
							questionB.setVisible(true);
							questionB.setBounds(248, 117, 136, 27);
							
							questionC.setVisible(true);
							questionC.setBounds(248, 167, 136, 27);
							
							questionD.setVisible(true);
							questionD.setBounds(248, 217, 136, 27);
							
							questionE.setVisible(true);
							questionE.setBounds(248, 267, 136, 27);
							
							result = (int)((correct_guesses/(double)total_questions)*100);
							number_right.setText("("+correct_guesses+"/"+total_questions+")");
							percentage.setText(result+"%");

							//adding the result value to the database
							PreparedStatement ps;
							int rs;
							Myconnection conn = new Myconnection();//connect
							String query="INSERT INTO numbercruncher.practice_test_grade(student_uname,3g2test) \n" +
									"VALUES (?,?)\n" +
									" on DUPLICATE key update 3g2test =?";
							try {

								ps = conn.getconnection().prepareStatement(query);//call the query
								ps.setString(1, login.getdata[0]);//insert user data
								ps.setString(2, String.valueOf(result));//insert result
								ps.setString(3, String.valueOf(result));//insert index data

								rs = ps.executeUpdate();//execute

							} catch (SQLException ex) {
								Logger.getLogger(phase3.login.class.getName()).log(Level.SEVERE, null, ex); }


							number_right.setVisible(true);
							percentage.setVisible(true);
							
					
							
							if (correct_guesses == 5 || correct_guesses == 4)
							{
								percentage.setForeground(new Color(0,128,0));
							}
							
							else if (correct_guesses == 3)
							{
								percentage.setForeground(new Color(204,204,0));
							}
							
							else
							{
								percentage.setForeground(new Color(255, 0 ,0));
							}
							
							
							
						
						}
						});
				}
				});
					
			
			
	
			
			
		
		
	}
	  

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(grade3OATUnitTestEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(grade3OATUnitTestEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(grade3OATUnitTestEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(grade3OATUnitTestEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new grade3OATUnitTestEasy().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JLabel back;
	private JButton classbut;
	private JLabel header;
	private JButton helpbut;
	private JButton homebut;
	private JLabel numcrunch;
	private JButton profilebut;
	private JButton progressbut;
	private JButton rewardsbut;
	private JLabel sidebar;
	private JButton unitbut;
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JTextPane textArea2;
	private JTextArea textArea4;
	private JTextPane textArea5;
	private JTextField textAnswer;
	private JLabel headerTitle;
	private JTextField questionB;
	private JTextField questionC;
	private JTextField questionF;
	private JTextField questionE;
	private JTextField questionD;
	private JButton resultsBut;
	private final JButton returntoResults = new JButton("RETURN TO RESULTS PAGE");
	private final JTextPane resultsTitle = new JTextPane();
	private final JLabel grade = new JLabel("GRADE:");
}