package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField pfield;
	private JTextField qfield;
	private JTextField efield;
	private JTextField nfield;
	private JTextField dfield;
	private JTextField n1field;
	private JTextField ok1field;
	private JTextField ok2field;
	private JTextField lk1field;
	private JTextField lk2field;
	private JTextField ok11field;
	private JTextField ok22field;
	private JTextField lk11field;
	private JTextField lk22field;
	private JTextField ok111field;
	private JTextField ok222field;
	private JTextField lk111field;
	private JTextField lk222field;
	private JTextField ok1111field;
	private JTextField ok2222field;
	private JTextField lk1111field;
	private JTextField lk2222field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setTitle("Lab 4 \u0410\u043B\u0433\u043E\u0440\u0438\u0442\u043C RSA \u0420\u0430\u043C\u0443\u043D\u0438\u0441 214.41");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u0413\u0435\u043D\u0435\u0440\u0430\u0446\u0438\u044F \u043A\u043B\u044E\u0447\u0435\u0439", null, panel, null);
		panel.setLayout(null);
		
		pfield = new JTextField();
		pfield.setBounds(20, 58, 163, 20);
		panel.add(pfield);
		pfield.setColumns(10);
		
		qfield = new JTextField();
		qfield.setBounds(20, 112, 163, 20);
		panel.add(qfield);
		qfield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041F\u0440\u043E\u0441\u0442\u043E\u0435 \u0447\u0438\u0441\u043B\u043E P");
		lblNewLabel.setBounds(20, 33, 124, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u041F\u0440\u043E\u0441\u0442\u043E\u0435 \u0447\u0438\u0441\u043B\u043E Q");
		lblNewLabel_1.setBounds(20, 87, 124, 14);
		panel.add(lblNewLabel_1);
		
		JPanel genpanel = new JPanel();
		genpanel.setBounds(20, 177, 164, 196);
		panel.add(genpanel);
		genpanel.setLayout(null);
		genpanel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("\u041E\u0442\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_2.setBounds(10, 11, 144, 14);
		genpanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("P(A) = { e , n }");
		lblNewLabel_3.setBounds(10, 36, 96, 14);
		genpanel.add(lblNewLabel_3);
		
		efield = new JTextField();
		efield.setBounds(10, 61, 53, 20);
		genpanel.add(efield);
		efield.setColumns(10);
		
		nfield = new JTextField();
		nfield.setBounds(71, 61, 53, 20);
		genpanel.add(nfield);
		nfield.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u0417\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_4.setBounds(10, 94, 131, 14);
		genpanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("S(A) = { d , n }");
		lblNewLabel_5.setBounds(10, 119, 114, 14);
		genpanel.add(lblNewLabel_5);
		
		dfield = new JTextField();
		dfield.setBounds(10, 144, 53, 20);
		genpanel.add(dfield);
		dfield.setColumns(10);
		
		n1field = new JTextField();
		n1field.setBounds(71, 144, 53, 20);
		genpanel.add(n1field);
		n1field.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0413\u0435\u043D\u0435\u0440\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int p=Integer.parseInt(pfield.getText());
				 int q=Integer.parseInt(qfield.getText());
					
				 app.RSAdll RSA = new RSAdll();
		         RSA.genkeys(p, q);
		         long[] openkey = RSA.getopenkey();
		         long[] lockkey = RSA.getlockkey();
		         
		         genpanel.setVisible(true);
		         efield.setText(String.valueOf(openkey[0]));
		         nfield.setText(String.valueOf(openkey[1]));
		         dfield.setText(String.valueOf(lockkey[0]));
		         n1field.setText(String.valueOf(lockkey[1]));
			}
		});
		btnNewButton.setBounds(20, 143, 163, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u043D\u0438\u0435", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u041E\u0442\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_6.setBounds(26, 22, 165, 14);
		panel_1.add(lblNewLabel_6);
		
		ok1field = new JTextField();
		ok1field.setBounds(26, 47, 64, 20);
		panel_1.add(ok1field);
		ok1field.setColumns(10);
		
		ok2field = new JTextField();
		ok2field.setBounds(94, 47, 64, 20);
		panel_1.add(ok2field);
		ok2field.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435");
		lblNewLabel_7.setBounds(26, 84, 132, 14);
		panel_1.add(lblNewLabel_7);
		
		JTextPane mfield = new JTextPane();
		mfield.setBounds(26, 109, 649, 132);
		panel_1.add(mfield);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 287, 649, 185);
		panel_1.add(textArea);
		
		JButton btnNewButton_1 = new JButton("\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long ok1=Integer.parseInt(ok1field.getText());
				long ok2=Integer.parseInt(ok2field.getText());
				String str = mfield.getText();
				
				
				long[] encode = new long[str.length()];
				app.RSAdll RSA = new RSAdll();
				
				char[] s = str.toCharArray();
				 int[] ss = new int[s.length]; //сообщение исходное
			        for (int i = 0; i < s.length; i++)
			        {
			            ss[i]=  ((int) s[i]);
			            encode[i] = RSA.Encrypt(ss[i], ok1, ok2);     
			        }
			        
			        for (int i = 0; i < encode.length; i++)
			        {
			        	 textArea.append(String.valueOf(encode[i])+" ");
			        }
			        
			}
		});
		btnNewButton_1.setBounds(24, 253, 134, 23);
		panel_1.add(btnNewButton_1);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u043A\u0430", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0417\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_8.setBounds(34, 28, 143, 14);
		panel_2.add(lblNewLabel_8);
		
		lk1field = new JTextField();
		lk1field.setBounds(34, 53, 61, 20);
		panel_2.add(lk1field);
		lk1field.setColumns(10);
		
		lk2field = new JTextField();
		lk2field.setBounds(102, 53, 61, 20);
		panel_2.add(lk2field);
		lk2field.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0428\u0438\u0444\u0440\u043E\u0442\u0435\u043A\u0441\u0442");
		lblNewLabel_9.setBounds(34, 84, 129, 14);
		panel_2.add(lblNewLabel_9);
		
		JTextPane crfield = new JTextPane();
		crfield.setBounds(34, 109, 659, 136);
		panel_2.add(crfield);
		
		JTextArea outfield = new JTextArea();
		outfield.setBounds(34, 287, 659, 185);
		panel_2.add(outfield);
		
		JButton btnNewButton_2 = new JButton("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long lk1=Integer.parseInt(lk1field.getText());
				long lk2=Integer.parseInt(lk2field.getText());
				
                String str1 = crfield.getText();
				
                String se[] = str1.split(" ");
				long[] decode = new long[str1.length()];
				app.RSAdll RSA = new RSAdll();
				
                for (int i = 0; i < se.length; i++)
		        {
		        	 decode[i] = Long.parseLong(se[i]);
		        	 decode[i] =  Long.parseLong(String.valueOf(RSA.Decrypt(decode[i], lk1, lk2)));
		        	 outfield.append(((char) decode[i])+"");
		        }
                
                //for (int i = 0; i < decode.length; i++)
		        //{
		       // 	 outfield.append(decode[i]+"\n");
		       // }
            //    char[] o = new char[decode.length];
             //   for (int i = 0; i < decode.length; i++) {
    	     //       o[i]=  ((char) ( decode[i]));    
    	     //       outfield.append(decode[i]+"\n");
    	     //   }
				
				
			}
		});
		btnNewButton_2.setBounds(33, 256, 156, 23);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C TXT", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u041E\u0442\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_10.setBounds(33, 26, 159, 14);
		panel_3.add(lblNewLabel_10);
		
		ok11field = new JTextField();
		ok11field.setBounds(33, 51, 104, 20);
		panel_3.add(ok11field);
		ok11field.setColumns(10);
		
		ok22field = new JTextField();
		ok22field.setBounds(140, 51, 104, 20);
		panel_3.add(ok22field);
		ok22field.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0438 \u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();
				    
				    try (BufferedReader reader = new BufferedReader(
				    	       new InputStreamReader(
				    	         new FileInputStream(file), "UTF8"))) {			    	
				    	//
				    	char[] buffer = new char[990000000];
				    	int n;
				    	StringBuilder sb = new StringBuilder();
				    	while ((n = reader.read(buffer)) != -1)
				    	{
				    		sb.append(buffer,0,n);
				    	}
				    	
				        //
				    	long ok11=Integer.parseInt(ok11field.getText());
						long ok22=Integer.parseInt(ok22field.getText());
						String str = sb.toString();
						
						
						long[] encode = new long[str.length()];
						app.RSAdll RSA = new RSAdll();
						
						char[] s = str.toCharArray();
						 int[] ss = new int[s.length]; //сообщение исходное
					        for (int i = 0; i < s.length; i++)
					        {
					            ss[i]=  ((int) s[i]);
					            encode[i] = RSA.Encrypt(ss[i], ok11, ok22);     
					        }
					        					    				        
					        try(FileWriter writer = new FileWriter(file.getPath(), false))
					        {
					           // запись всей строки	
					        	for (int i = 0; i < encode.length; i++)
							       {
					        		writer.write(String.valueOf(encode[i])+" ");
							       }					        	
					            writer.flush();
					            					    
					            JOptionPane.showMessageDialog(contentPane, "Зашифровано");
					        }
					        catch(IOException ex){
					             
					            System.out.println(ex.getMessage());
					        } 
				    	
				    	//				    	
				    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    }
				
			}
		});
		btnNewButton_3.setBounds(33, 82, 211, 30);
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C TXT", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0417\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_11.setBounds(32, 28, 151, 14);
		panel_4.add(lblNewLabel_11);
		
		lk11field = new JTextField();
		lk11field.setBounds(31, 53, 78, 20);
		panel_4.add(lk11field);
		lk11field.setColumns(10);
		
		lk22field = new JTextField();
		lk22field.setBounds(113, 53, 86, 20);
		panel_4.add(lk22field);
		lk22field.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0438 \u0440\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();
				    
				    try (BufferedReader reader = new BufferedReader(
				    	       new InputStreamReader(
				    	         new FileInputStream(file), "UTF8"))) {			    	
				    	//
				    	char[] buffer = new char[990000000];
				    	int n;
				    	StringBuilder sb = new StringBuilder();
				    	while ((n = reader.read(buffer)) != -1)
				    	{
				    		sb.append(buffer,0,n);
				    	}
				    	
				        //
				    	long lk11=Integer.parseInt(lk11field.getText());
						long lk22=Integer.parseInt(lk22field.getText());
						String str1 = sb.toString();
										
						    String se[] = str1.split(" ");
							long[] decode = new long[str1.length()];
							app.RSAdll RSA = new RSAdll();
							
			                for (int i = 0; i < se.length; i++)
					        {
					        	 decode[i] = Long.parseLong(se[i]);
					        	 decode[i] =  Long.parseLong(String.valueOf(RSA.Decrypt(decode[i], lk11, lk22)));					        	 
   				           }
					        					    				        
					        try(FileWriter writer = new FileWriter(file.getPath(), false))
					        {
					           // запись всей строки	
					        	for (int i = 0; i < se.length; i++)
							       {
					        		writer.write(String.valueOf(((char) decode[i])+""));
							       }					        	
					            writer.flush();
					            					    
					            JOptionPane.showMessageDialog(contentPane, "Расшифровано");
					        }
					        catch(IOException ex){
					             
					            System.out.println(ex.getMessage());
					        } 
				    	
				    	//				    	
				    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    }
								
			}
		});
		btnNewButton_4.setBounds(32, 84, 167, 23);
		panel_4.add(btnNewButton_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C Base64", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u041E\u0442\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_12.setBounds(42, 57, 197, 14);
		panel_5.add(lblNewLabel_12);
		
		ok111field = new JTextField();
		ok111field.setBounds(42, 82, 76, 20);
		panel_5.add(ok111field);
		ok111field.setColumns(10);
		
		ok222field = new JTextField();
		ok222field.setBounds(128, 82, 86, 20);
		panel_5.add(ok222field);
		ok222field.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0438 \u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.RSAdll RSA = new RSAdll();
				long ok111=Integer.parseInt(ok111field.getText());
				long ok222=Integer.parseInt(ok222field.getText());
				
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();			    
				    //			    
				    FileInputStream imageStream = null;
					try {
						imageStream = new FileInputStream(file.getPath());  //1
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					byte[] data = null;
					try {
						data = imageStream.readAllBytes(); //2
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String imageString = Base64.getEncoder().encodeToString(data); //3
					String output = "";
					
					char[] s = imageString.toCharArray();            //4
					int[] ss = new int[s.length];
					for (int i = 0; i < s.length; i++) {
			            ss[i]=  ((int) s[i]);
			            ss[i] = RSA.Encrypt(ss[i],ok111, ok222);    //5
			            s[i] = (char) ss[i];
			            output += s[i];        //6
			           //txtout.append( s[i]+"\n");
			        }
					FileWriter fileWriter = null;
					try {
						fileWriter = new FileWriter(file.getPath(),StandardCharsets.UTF_8); //6
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						fileWriter.write(s);  //7
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						fileWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						imageStream.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(contentPane, "Зашифровано");
				    
				}			
			}
		});
		btnNewButton_5.setBounds(42, 113, 172, 23);
		panel_5.add(btnNewButton_5);
		
		JLabel lblNewLabel_14 = new JLabel("\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C \u043B\u044E\u0431\u044B\u0435 \u0444\u0430\u0439\u043B\u044B: \u0418\u0437\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u044F(png,bmp,jpg), \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u044B(DOCX,PDF),\u043C\u0443\u043B\u044C\u0442\u0438\u043C\u0435\u0434\u0438\u0430(AVI,MP4)");
		lblNewLabel_14.setBounds(42, 15, 651, 31);
		panel_5.add(lblNewLabel_14);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C Base64", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0417\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_13.setBounds(31, 50, 172, 14);
		panel_6.add(lblNewLabel_13);
		
		lk111field = new JTextField();
		lk111field.setBounds(31, 75, 70, 20);
		panel_6.add(lk111field);
		lk111field.setColumns(10);
		
		lk222field = new JTextField();
		lk222field.setBounds(104, 75, 70, 20);
		panel_6.add(lk222field);
		lk222field.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0438 \u0440\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.RSAdll RSA = new RSAdll();
				long lk111=Integer.parseInt(lk111field.getText());
				long lk222=Integer.parseInt(lk222field.getText());
				
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();
				    
				    Path path = Paths.get(file.getPath());
			        try {

			            // Java 11
			            String str = Files.readString(path, StandardCharsets.UTF_8);  //1
			            char[] s = str.toCharArray();            
						int[] ss = new int[s.length];
						for (int i = 0; i < s.length; i++) {
				          
						  ss[i] = (int) s[i]; //2
						  ss[i] =  (int) Long.parseLong(String.valueOf(RSA.Decrypt(ss[i], lk111, lk222))); //3
						  s[i] = (char) ss[i]; //4
				         // txtout.append( s[i]+"\n");
				        }
						FileWriter fileWriter = new FileWriter(file.getPath()); 
						
						fileWriter.write(s);  //5
						
						fileWriter.close();
						
			            
			            
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
			        
			        //
			        FileInputStream inputStream = null;
					try {
						inputStream = new FileInputStream(file.getPath());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	//6
			        byte[] data = null;
					try {
						data = Base64.getDecoder().decode(new String(inputStream.readAllBytes())); //7
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} 
					FileOutputStream fileOutputStream = null;
					try {
						fileOutputStream = new FileOutputStream(file.getPath());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						fileOutputStream.write(data); //8
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} //8
					try {
						fileOutputStream.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			    }
				JOptionPane.showMessageDialog(contentPane, "Расшифровано"); 
				    
				}
			
		});
		btnNewButton_6.setBounds(31, 106, 143, 23);
		panel_6.add(btnNewButton_6);
		
		JLabel lblNewLabel_15 = new JLabel("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C \u043B\u044E\u0431\u044B\u0435 \u0444\u0430\u0439\u043B\u044B: \u0418\u0437\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u044F(png,bmp,jpg), \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u044B(DOCX,PDF),\u043C\u0443\u043B\u044C\u0442\u0438\u043C\u0435\u0434\u0438\u0430(AVI,MP4)");
		lblNewLabel_15.setBounds(31, 11, 617, 14);
		panel_6.add(lblNewLabel_15);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("\u0428\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C \u041A\u0430\u0442\u0430\u043B\u043E\u0433", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u041E\u0442\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_16.setBounds(41, 35, 210, 14);
		panel_7.add(lblNewLabel_16);
		
		ok1111field = new JTextField();
		ok1111field.setBounds(41, 57, 76, 20);
		panel_7.add(ok1111field);
		ok1111field.setColumns(10);
		
		ok2222field = new JTextField();
		ok2222field.setBounds(120, 57, 76, 20);
		panel_7.add(ok2222field);
		ok2222field.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0438 \u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.RSAdll RSA = new RSAdll();
				long ok1111=Integer.parseInt(ok1111field.getText());
				long ok2222=Integer.parseInt(ok2222field.getText());
				
				JFileChooser fileopen = new JFileChooser();
				fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();
				    
				    ArrayList<String> list = new ArrayList<String>();
					
					Path p = Paths.get(file.getPath());
					try (Stream<Path> stream = Files.walk(p, 3)) {
						stream.forEachOrdered(
								(path) -> list.add(path.toString())
						);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//
					//for(String person : list){
				          
			           // System.out.println(person);
			        //}
					String[] stringArray = list.toArray(new String[0]);
					
					for (int j=1;j<stringArray.length;j++)
					{
						//System.out.print(stringArray[j]+"\n");
						 FileInputStream imageStream = null;
							try {
								imageStream = new FileInputStream(stringArray[j]);  //1
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							byte[] data = null;
							try {
								data = imageStream.readAllBytes(); //2
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							String imageString = Base64.getEncoder().encodeToString(data); //3
							String output = "";
							
							char[] s = imageString.toCharArray();            //4
							int[] ss = new int[s.length];
							for (int i = 0; i < s.length; i++) {
					            ss[i]=  ((int) s[i]);
					            ss[i] = RSA.Encrypt(ss[i],ok1111, ok2222);    //5
					            s[i] = (char) ss[i];
					            output += s[i];        //6
					           //txtout.append( s[i]+"\n");
					        }
							FileWriter fileWriter = null;
							try {
								fileWriter = new FileWriter(stringArray[j],StandardCharsets.UTF_8); //6
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								fileWriter.write(s);  //7
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								fileWriter.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								imageStream.close();
								//JOptionPane.showMessageDialog(contentPane, "1 файл зашифрован");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}														
					}
					JOptionPane.showMessageDialog(contentPane, "Зашифровано");
				    
				}							    		
			}
		});
		btnNewButton_7.setBounds(41, 88, 155, 23);
		panel_7.add(btnNewButton_7);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C \u043A\u0430\u0442\u0430\u043B\u043E\u0433", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0417\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447");
		lblNewLabel_17.setBounds(22, 29, 212, 14);
		panel_8.add(lblNewLabel_17);
		
		lk1111field = new JTextField();
		lk1111field.setBounds(22, 54, 76, 20);
		panel_8.add(lk1111field);
		lk1111field.setColumns(10);
		
		lk2222field = new JTextField();
		lk2222field.setBounds(102, 54, 76, 20);
		panel_8.add(lk2222field);
		lk2222field.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0438 \u0440\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				app.RSAdll RSA = new RSAdll();
				long lk1111=Integer.parseInt(lk1111field.getText());
				long lk2222=Integer.parseInt(lk2222field.getText());
				
				JFileChooser fileopen = new JFileChooser();
				fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int ret = fileopen.showDialog(null, "Открыть файл");                
				if (ret == JFileChooser.APPROVE_OPTION) {
				    File file = fileopen.getSelectedFile();
				    
				    ArrayList<String> list = new ArrayList<String>();
					
					Path p = Paths.get(file.getPath());
					try (Stream<Path> stream = Files.walk(p, 3)) {
						stream.forEachOrdered(
								(path) -> list.add(path.toString())
						);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//
					//for(String person : list){
				          
			           // System.out.println(person);
			        //}
					String[] stringArray = list.toArray(new String[0]);
					
					for (int j=1;j<stringArray.length;j++)
					{
						 Path path = Paths.get(stringArray[j]);
						 try {

					            // Java 11
					            String str = Files.readString(path, StandardCharsets.UTF_8);  //1
					            char[] s = str.toCharArray();            
								int[] ss = new int[s.length];
								for (int i = 0; i < s.length; i++) {
						          
								  ss[i] = (int) s[i]; //2
								  ss[i] =  (int) Long.parseLong(String.valueOf(RSA.Decrypt(ss[i], lk1111, lk2222))); //3
								  s[i] = (char) ss[i]; //4
						         // txtout.append( s[i]+"\n");
						        }
								FileWriter fileWriter = new FileWriter(stringArray[j]); 
								
								fileWriter.write(s);  //5
								
								fileWriter.close();
								
					            
					            
					        } catch (IOException e1) {
					            e1.printStackTrace();
					        }
					        
					        //
					        FileInputStream inputStream = null;
							try {
								inputStream = new FileInputStream(stringArray[j]);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	//6
					        byte[] data = null;
							try {
								data = Base64.getDecoder().decode(new String(inputStream.readAllBytes())); //7
							} catch (IOException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							} 
							FileOutputStream fileOutputStream = null;
							try {
								fileOutputStream = new FileOutputStream(stringArray[j]);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								fileOutputStream.write(data); //8
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} //8
							try {
								fileOutputStream.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
					}
					JOptionPane.showMessageDialog(contentPane, "Расшифровано");
			}
			}
		});
		btnNewButton_8.setBounds(22, 85, 156, 23);
		panel_8.add(btnNewButton_8);
		
		
	}
}
