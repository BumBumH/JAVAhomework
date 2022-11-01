import java.awt.Image;
//오류import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{
  

  //배경이미지 (에러)
  // private Image background=new ImageIcon(MainController.class.getResource("./button_Image/stage.png")).getImage();
  //바위버튼
  private JButton buttonRock;
  
  //가위버튼
  private JButton buttonScissors;
  
  //보버튼
  private JButton buttonPaper;
  
  //코인 버튼 (에러)
  //private JButton buttonCoin;
  
  //서브타이틀
  private JLabel labelSubTitle = new JLabel("버튼을 눌러주세요");
  
  public MainFrame(){
    super("가위바위보 게임");
    
    super.setBounds(500,500,800,800);
    
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();

    //JButton의 사진을 리사이즈 하기 위해선 ImageIcon작성⇒Image오브젝트 추출하여 재지정 ⇒ImageIcon으로 재 설정
    ImageIcon imageRock = new ImageIcon("./button_Image/rock.png");
    imageRock.setImage(imageRock.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonRock = new JButton(imageRock);
    
    ImageIcon imageScissors = new ImageIcon("./button_Image/sc.png");
    imageScissors.setImage(imageScissors.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonScissors = new JButton(imageScissors);
    
    ImageIcon imagePaper = new ImageIcon("./button_Image/paper.png");
    imagePaper.setImage(imagePaper.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonPaper = new JButton(imagePaper);
    
    //ImageIcon imageCoin = new ImageIcon("./button_Image/coin.png");
    imagePaper.setImage(imagePaper.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonPaper = new JButton(imagePaper);
    
    super.add("North",labelSubTitle);
    
    panel.add(buttonRock);
    panel.add(buttonScissors);
    panel.add(buttonPaper);
    labelSubTitle.add(panel);
   //에러 panel.add(buttonCpu);
    super.add("South", panel);
    
    super.setVisible(true);
    
  }
  
  /**
   * 서브타이틀 설정.
   * @param subTitle
   */
  public void setSubTitle(String subTitle){
    labelSubTitle.setText(subTitle);
  }

  public JButton getButtonRock() {
    return buttonRock;
  }

  public JButton getButtonScissors() {
    return buttonScissors;
  }

  public JButton getButtonPaper() {
    return buttonPaper;
  }
  //public JButton getButtonCoin() {
	   // return buttonCoin;
	  }
  

