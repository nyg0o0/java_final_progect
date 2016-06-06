 /** SicBo game
 *   Variables List - 
 *     userName: 玩家名稱輸入
 *     roundNumber: 計算回合數
 *     property: 財產
 *
 */

import java.util.Scanner;

public class TestSicBo {

	/** Main method */
	public static void main(String[] args){
		
		//印出遊戲名稱與規則
		System.out.println("\n骰寶");
		System.out.println("******************************************************************************");
		System.out.println("* 遊戲規則：                                                                 *");
		System.out.println("*                                                                            *");
		System.out.println("* １.玩家一開始有5000元資本，可一直玩到沒資本為止。                          *");
		System.out.println("*                                                                            *");

		System.out.println("* ２.電腦是莊家，每一輪莊家會骰三顆骰子，玩家依自己意願可重複下注。  　      *");
		System.out.println("*    下注種類以及勝出方法如下：                                              *");
		System.out.println("*                                                                            *");
		System.out.println("*　  (1)大：總點數為11至17，但不包含圍骰狀況（三顆骰皆為4或5或6）            *");
		System.out.println("*　  (2)小：總點數為4至10，但不包含圍骰狀況（三顆骰皆為1或2或3）             *");
		System.out.println("*　  (3)全骰（豹子）：不指定點數，三顆骰子點數全同                           *");
		System.out.println("*　  (4)兩顆骰子：猜中骰出的骰子其中兩顆之組合，而這兩顆骰子的點數不一樣     *");
		System.out.println("*　  (5)雙骰：猜中骰出的骰子其中兩顆之組合，而這兩顆骰子的點數一樣           *");
		System.out.println("*　  (6)圍骰：指定點數，三顆骰子點數全同（例如:圍一、一豹子）                *");
		System.out.println("*                                                                            *");

		System.out.println("* ３.各下注種類之賠率：                                                      *");
		System.out.println("*　   －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－   *");
		System.out.println("*　  ｜　　大　　|　　小　　| 兩顆骰子 |　 雙骰 　|　 全骰 　|　 圍骰 　 ｜  *");
		System.out.println("*　  ｜－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－  ｜  *");
		System.out.println("*　  ｜　 1賠1 　|　 1賠1 　|　 1賠5 　|　 1賠8 　|　 1賠24　|　1賠150　 ｜  *");
		System.out.println("*　   －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－   *");
		System.out.println("******************************************************************************");

		//客製化玩家名稱,並歡迎玩家進入遊戲
		System.out.print("請輸入玩家名稱: ");
		Scanner input = new Scanner(System.in);
		String userName = input.nextLine();
		System.out.println("");
		System.out.println("------------ 歡迎 " + userName +" 來到混吃等死賭場 ------------");
		System.out.println("");

		//初始化:是否要再玩一次,已玩局數,財產
		boolean repeatGame = false;
		int roundNumber = 1;
		int bets=0;
		int sale=0;
		SicBo game = new SicBo();
		if ( userName.equals("混吃等死就是要賭") ){
			game.initialProperty(50000);
		}
		else{
			game.initialProperty(5000);
		}


		//開始遊戲		
		do{
			System.out.println("您目前的財產: " + game.getProperty() );
			//印出該局數,請玩家輸入欲賭金額
			do{
				System.out.print("第" + roundNumber + "局, 請輸入本局賭注金額: ");
				bets = input.nextInt();
				game.bet(bets);
				if(game.getProperty() == 0){
					System.out.println("很抱歉!您已經破產了!");
					System.out.print("賣腎可賣得5000元，要賣嗎? (y/n) ");
					Scanner ask = new Scanner(System.in);
					String askStr = ask.nextLine();
					if ( askStr.equals("y") && sale<2 ){
						System.out.println("已賣了"+(sale+1)+"顆腎，得到5000元");
						game.initialProperty(5000);
						sale++;
					}
					else if(sale>=2){
						System.out.println("很抱歉!您已經破產了!");
						System.out.println("2顆腎也賣光了!!");
						System.out.println("Bye~Bye~");
						sale++;
						break;
					}
					else{
						System.out.println("Bye~Bye~");
						sale += 3;
						break;
					}
				}
				else if(game.getProperty() < bets){
					System.out.println("很抱歉!您的財產沒有這麼多!");
				}
			}while(game.getProperty() < bets);

			//如果已經賣了2顆腎，則跳出
			if(sale>2)
				break;

			//請玩家輸入欲睹的選項
			System.out.print("\n請問要賭哪個選項? (1)大, (2)小, (3)全骰（豹子）, (4)兩顆骰子, (5)雙骰, (6)圍骰\n您的選擇是: ");
			int choose = input.nextInt();

			//針對欲睹選項,進入到骰寶class內之對應選項,看其輸贏
			switch(choose){
				//選擇賭「大」
				case 1: 
					System.out.println("您選擇的是賭「大」");
					game.rollDice();
					game.rollDiceResult();
					game.big();
					break;

				//選擇賭「小」
				case 2: 
					System.out.println("您選擇的是賭「小」");
					game.rollDice();
					game.rollDiceResult();
					game.small();
					break;


				//選擇賭「全骰」
				case 3: 
					System.out.println("您選擇的是賭「全骰（豹子）」");
					game.rollDice();
					game.rollDiceResult();
					game.anyTriples();
					break;
 
				//選擇賭「兩顆骰子」
				case 4: 
					System.out.println("您選擇的是賭「兩顆骰子」");
					System.out.print("請輸入第一個骰子點數: ");
					int guess1 = input.nextInt();
					System.out.println("");
					System.out.print("請輸入第二個骰子點數: ");
					int guess2 = input.nextInt();
					System.out.println("");
					game.rollDice();
					game.rollDiceResult();
					game.twoDiceCombination(guess1,guess2);
					break;

				//選擇賭「雙骰」
				case 5: 
					System.out.println("您選擇的是賭「雙骰」");
					System.out.print("請輸入雙骰的點數: ");
					int guessTwo = input.nextInt();
					System.out.println("");
					game.rollDice();
					game.rollDiceResult();
					game.specificDoubles(guessTwo);
					break;

				//選擇賭「圍骰」
				case 6: 
					System.out.println("您選擇的是賭「圍骰」");
					System.out.print("請輸入圍骰的點數: ");
					int guessThree = input.nextInt();
					System.out.println("");
					game.rollDice();
					game.rollDiceResult();
					game.specificDoubles(guessThree);
					break;

				default:
			}//end switch

			//顯示幕前的財產
			System.out.printf("**     您 剩 餘 的 財 產 : %7d  元整            **\n",game.getProperty());
			System.out.printf("******************************************************\n");
			roundNumber++;//玩完一局,局數加一

			//詢問玩家是否要再完一次
			System.out.print("還要再來一局嗎? (y/n) ");
			Scanner input2 = new Scanner(System.in);
			String playAgainStr = input2.nextLine();
			System.out.println("");
			if ( playAgainStr.equals("y") ){
				repeatGame = true;
			}
			else{
				repeatGame = false;
			}

		}while( repeatGame == true );//再玩一次
	}
}