import java.util.Random;

class SicBo{
	//初始化骰子,骰子和,財產,賭金
	private int dice1,dice2,dice3,total;
	private int property,bet;

	//設定財產變動
	private void setProperty(int bet){
		if(property==0)
			System.out.println("財產輸光啦~");
		else
			property += bet;
	}//end setProperty
	
	//初始化財產
	public void initialProperty(int property){
		this.property=property;
	}//end initialProperty
	
	//下注
	public void bet(int bet){
		this.bet=bet;
	}//end bet

	//骰骰子
	public void rollDice(){
		Random randomNumber = new Random();
		dice1 = 1+randomNumber.nextInt(6);
		dice2 = 1+randomNumber.nextInt(6);
		dice3 = 1+randomNumber.nextInt(6);
		total = dice1 + dice2 + dice3;
	}//end rollDice

	public void rollDiceResult(){
		System.out.printf("******************************************************\n");
		System.out.printf("**         骰   子   結   果                        **\n");
		System.out.printf("******************************************************\n");
		System.out.printf("**         骰 子 點 數 :  %2d                        **\n",dice1);
		System.out.printf("**         骰 子 點 數 :  %2d                        **\n",dice2);
		System.out.printf("**         骰 子 點 數 :  %2d                        **\n",dice3);
		System.out.printf("**                                                  **\n");
		System.out.printf("**         點 數 總 和 :  %2d                        **\n",total);
		System.out.printf("******************************************************\n");
	}//end rollDiceResult
	
	//判斷是否為’圍骰’
	public boolean triples(){
		if(dice1==dice2 && dice2==dice3)
			return true;
		else
			return false;
	}//end triples

	//判斷’大’的輸贏
	public void big(){
		if(total>=11 && total<=17 && triples()==false){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(bet);
		}
		else{
			System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end big

	//判斷’小’ 輸贏
	public void small(){
		if(total>=4 && total<=10 && triples()==false){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(bet);
		}
		else{
			System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end small

	//判斷’全圍’的輸贏
	public void anyTriples(){
		if(triples()==true){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*24) );
			System.out.printf("******************************************************\n");
			setProperty(bet*24);
		}
		else{
			System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end anyTriples

	//判斷’兩顆骰子’的輸贏
	public void twoDiceCombination(int guess1,int guess2){
		if(dice1 == guess1){
			if(dice2 == guess2 || dice3 == guess2){
				System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*5) );
				System.out.printf("******************************************************\n");
				setProperty(bet*5);
			}
			else{
				System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
				System.out.printf("******************************************************\n");
				setProperty(-bet);
			}	
		}
		else if(dice2 == guess1){
			if(dice1 == guess2 || dice3 == guess2){
				System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*5) );
				System.out.printf("******************************************************\n");
				setProperty(bet*5);
			}
			else{
				System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
				System.out.printf("******************************************************\n");
				setProperty(-bet);
			}	
		}
		else if(dice3 == guess1){
			if(dice1 == guess2 || dice2 == guess2){
				System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*5) );
				System.out.printf("******************************************************\n");
				setProperty(bet*5);
			}
			else{
				System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
				System.out.printf("******************************************************\n");
				setProperty(-bet);
			}	
		}
		else{
			System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end twoDiceCombination

	//判斷’雙骰’的輸贏
	public void specificDoubles(int guessTwo){
		if(dice1 == guessTwo && dice2 == guessTwo){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*8) );
			System.out.printf("******************************************************\n");
			setProperty(bet*8);
		}
		else if(dice2 == guessTwo && dice3 == guessTwo){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*8) );
			System.out.printf("******************************************************\n");
			setProperty(bet*8);
		}
		else if(dice1 == guessTwo && dice3 == guessTwo){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*8) );
			System.out.printf("******************************************************\n");
			setProperty(bet*8);
		}
		else{
			System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end specificDoubles

	//判斷’圍骰’的輸贏
	public void specificTriples(int guessThree){
		if(dice1 == guessThree && dice2 == guessThree && dice3 == guessThree){
			System.out.printf("**     恭 喜 您 贏 得 :%4d 元整                    **\n",(bet*150) );
			System.out.printf("******************************************************\n");
			setProperty(bet*150);
		}
		else{
			System.out.printf("**     這 局 您 輸 了 :%4d 元整                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end specificTriples

	//傳回現在財產
	public int getProperty(){
		return property;
	}

	//傳回第一顆骰子點數
	public int getDice1(){
		return dice1;
	}

	//傳回第二顆骰子點數
	public int getDice2(){
		return dice2;
	}

	//傳回第三顆骰子點數
	public int getDice3(){
		return dice3;
	}
}
