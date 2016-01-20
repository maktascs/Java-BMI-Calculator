import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class BMI extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField mheight;
	private JTextField mweight;
	private JTextField mbmi;
	private JTextField sheight;
	private JTextField sweight;
	private JTextField sbmi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI frame = new BMI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static boolean  isValidNumber(String value){
		if(value.length()==0){
			return false;
		}
		for(int i=0;i<value.length();i++){
			if(  !Character.isDigit(value.charAt(i))){
				return false;
				
			}
			
		}	
		return true;
	}
	public BMI() {
		setTitle("Aktas' BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Standart", null, panel, null);
		panel.setLayout(null);
		
		JTextArea txtrBmiCategoriesUnderweight_1 = new JTextArea();
		txtrBmiCategoriesUnderweight_1.setForeground(new Color(128, 0, 128));
		txtrBmiCategoriesUnderweight_1.setBackground(new Color(253, 245, 230));
		txtrBmiCategoriesUnderweight_1.setBounds(215, 11, 184, 155);
		txtrBmiCategoriesUnderweight_1.setText("BMI Categories: \r\nUnderweight = <18.5\r\nNormal weight = 18.5\u201324.9 \r\n\r\nOverweight = 25\u201329.9 \r\nObesity = 30 or greater");
		txtrBmiCategoriesUnderweight_1.setLineWrap(true);
		txtrBmiCategoriesUnderweight_1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrBmiCategoriesUnderweight_1.setEditable(false);
		panel.add(txtrBmiCategoriesUnderweight_1);
		
		JButton button = new JButton("Calculate BMI");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(isValidNumber(sheight.getText()) && isValidNumber(sweight.getText())){
					int sheightv=Integer.parseInt(sheight.getText());
					int sweightv=Integer.parseInt(sweight.getText());
					double bmiR2;					
					bmiR2=(sweightv/(sheightv*(double)sheightv))*703;
					DecimalFormat df2=new DecimalFormat("##.##");
					sbmi.setText(df2.format(bmiR2));
				}
				else{
					JOptionPane.showMessageDialog(null, "Please enter valid numbers");
					
				}
					
				}				
				
				
							
		
		});
		
		button.setBounds(74, 81, 131, 35);
		panel.add(button);
		
		JLabel lblYourHeightin = new JLabel("Your Height (in): ");
		lblYourHeightin.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYourHeightin.setBounds(10, 12, 115, 23);
		panel.add(lblYourHeightin);
	
		sheight = new JFormattedTextField();
		sheight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sheight.setText("");
			}
				
		});
		sheight.setText("36-102 in");
		sheight.setToolTipText("Enter Height between 36-102 Inches");
		sheight.setColumns(10);
		sheight.setBounds(121, 12, 86, 20);
		panel.add(sheight);
		
		
		
		//label creation
		JLabel lblYourWeightlbs = new JLabel("Your Weight (lbs):");
		lblYourWeightlbs.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYourWeightlbs.setBounds(10, 47, 124, 23);
		panel.add(lblYourWeightlbs);

		sweight = new JFormattedTextField();
		sweight.setText("10-1400 lbs");
		sweight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sweight.setText("");
			}
		});
		sweight.setColumns(10);
		sweight.setBounds(121, 50, 86, 20);
		sweight.setToolTipText("Enter Weight between 10-1400 pounds");
		panel.add(sweight);
		
		JLabel label_2 = new JLabel("Your BMI:");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		label_2.setBounds(23, 143, 86, 23);
		panel.add(label_2);
		
		sbmi = new JTextField();
		sbmi.setEditable(false);
		sbmi.setColumns(10);
		sbmi.setBounds(121, 144, 86, 20);
		panel.add(sbmi);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Metric", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnCalculate = new JButton("Calculate BMI");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isValidNumber(mheight.getText()) && isValidNumber(mweight.getText())){
				double bmiR;
				bmiR=(Integer.parseInt(mweight.getText())/(Integer.parseInt(mheight.getText())*(double)Integer.parseInt(mheight.getText())/10000));
				DecimalFormat df=new DecimalFormat("##.##");
				mbmi.setText(df.format(bmiR));
				}
				else{
					JOptionPane.showMessageDialog(null, "Please enter valid numbers");
					
				}
				
				}
				
		});
		btnCalculate.setBounds(74, 81, 131, 35);
		panel_1.add(btnCalculate);
		
		JLabel lblYourHeightcm = new JLabel("Your Height (cm): ");
		lblYourHeightcm.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYourHeightcm.setBounds(10, 12, 115, 23);
		panel_1.add(lblYourHeightcm);
		
		mheight = new JFormattedTextField();
		
		mheight.setBounds(121, 12, 86, 20);
		panel_1.add(mheight);
		mheight.setToolTipText("Enter Height between 91-260 cm");
		mheight.setColumns(10);
		
		JLabel lblYourWeightkg = new JLabel("Your Weight (kg):");
		lblYourWeightkg.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYourWeightkg.setBounds(10, 47, 124, 23);
		panel_1.add(lblYourWeightkg);
		
		mweight = new JFormattedTextField();
		mweight.setBounds(121, 50, 86, 20);
		panel_1.add(mweight);
		mweight.setToolTipText("Enter Weight between 4-635 kg");
		mweight.setColumns(10);
		
		JLabel lblYourBmi = new JLabel("Your BMI:");
		lblYourBmi.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblYourBmi.setBounds(23, 143, 86, 23);
		panel_1.add(lblYourBmi);
		
		mbmi = new JTextField();
		mbmi.setEditable(false);
		mbmi.setBounds(121, 145, 86, 20);
		panel_1.add(mbmi);
		mbmi.setColumns(10);
		
		JTextArea txtrBmiCategoriesUnderweight = new JTextArea();
		txtrBmiCategoriesUnderweight.setEditable(false);
		txtrBmiCategoriesUnderweight.setBackground(new Color(216, 191, 216));
		txtrBmiCategoriesUnderweight.setLineWrap(true);
		txtrBmiCategoriesUnderweight.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrBmiCategoriesUnderweight.setText("BMI Categories: \r\nUnderweight = <18.5\r\nNormal weight = 18.5\u201324.9 \r\nOverweight = 25\u201329.9 \r\nObesity = 30 or greater");
		txtrBmiCategoriesUnderweight.setBounds(215, 11, 184, 155);
		panel_1.add(txtrBmiCategoriesUnderweight);
		
		JLabel lblNewLabel = new JLabel("Powered by Muammer Aktas");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Muammer Aktas is a beginner programmer.\nTrying to have fun with Java.\nPlease email me (aktastx@gmail.com) if you have any suggestions/complaints/feedback for me.\nThanks");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(getForeground());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.BLUE);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(270, 250, 154, 14);
		contentPane.add(lblNewLabel);
		
		
	}
}
