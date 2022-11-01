import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class MainController implements ActionListener{
  
  private final String CODE_ROCK = "바위";
  private final String CODE_SCISSORS = "가위";
  private final String CODE_PAPER = "보";

  private MainFrame mainFrame = new MainFrame();

  public MainController(){
    //가위 바위 보 버튼 리스너를 설정 
    mainFrame.getButtonRock().addActionListener(this);
    mainFrame.getButtonScissors().addActionListener(this);
    mainFrame.getButtonPaper().addActionListener(this);
    // 수정대기 getButtonSelect().addActionListener(this);
  }
  
  //승리 패턴을 문자열 화 해두고 "내가 는 것":"상대가 낸 것"
  private List<String> victoryList;
  {
    this.victoryList = new ArrayList<String>();
    this.victoryList.add(this.CODE_ROCK + ":" + this.CODE_SCISSORS);
    this.victoryList.add(this.CODE_SCISSORS + ":" + this.CODE_PAPER);
    this.victoryList.add(this.CODE_PAPER + ":" + this.CODE_ROCK);
  }
  
  //눌린 버튼과 작동 버튼의 매칭화 ??
  private Map<Object, String> rpsMap; 
  {
    //오브잭트의 등가로 판단했기 때문에 IdentityHashMap을 사용 (이유 모름)
    this.rpsMap = new IdentityHashMap<Object, String>();
    this.rpsMap.put(this.mainFrame.getButtonRock(),this.CODE_ROCK);
    this.rpsMap.put(this.mainFrame.getButtonScissors(),this.CODE_SCISSORS);
    this.rpsMap.put(this.mainFrame.getButtonPaper(),this.CODE_PAPER);

  }
  
  /** 
   * 가위바위보 버튼 입력 시 액션 리스너 
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //눌린 버튼으로 코드치를 추출 
    String result = this.rpsMap.get(e.getSource());
    
    //컴퓨터의 선택을 랜덤으로 설정
    Random random = new Random();
    String cpuResult = new String[]{this.CODE_ROCK,this.CODE_SCISSORS,this.CODE_PAPER}[random.nextInt(3)];
    
    //비김 
    if(result.equals(cpuResult)){
      this.mainFrame.setSubTitle("저는" + cpuResult + "를 냈습니다. 비겼습니다.");
    //승리
    }else if(this.victoryList.contains(result + ":" + cpuResult)){
      this.mainFrame.setSubTitle("저는" + cpuResult + "를 냈습니다. 당신의 승리입니다.");
    //패배
    }else{
      this.mainFrame.setSubTitle("저는" + cpuResult + "를 냈습니다. 당신의 패배입니다.");
      
    }
  }
}