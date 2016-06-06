import java.util.Random;

class SicBo{
	//��l�ƻ�l,��l�M,�]��,���
	private int dice1,dice2,dice3,total;
	private int property,bet;

	//�]�w�]���ܰ�
	private void setProperty(int bet){
		if(property==0)
			System.out.println("�]�������~");
		else
			property += bet;
	}//end setProperty
	
	//��l�ư]��
	public void initialProperty(int property){
		this.property=property;
	}//end initialProperty
	
	//�U�`
	public void bet(int bet){
		this.bet=bet;
	}//end bet

	//���l
	public void rollDice(){
		Random randomNumber = new Random();
		dice1 = 1+randomNumber.nextInt(6);
		dice2 = 1+randomNumber.nextInt(6);
		dice3 = 1+randomNumber.nextInt(6);
		total = dice1 + dice2 + dice3;
	}//end rollDice

	public void rollDiceResult(){
		System.out.printf("******************************************************\n");
		System.out.printf("**         ��   �l   ��   �G                        **\n");
		System.out.printf("******************************************************\n");
		System.out.printf("**         �� �l �I �� :  %2d                        **\n",dice1);
		System.out.printf("**         �� �l �I �� :  %2d                        **\n",dice2);
		System.out.printf("**         �� �l �I �� :  %2d                        **\n",dice3);
		System.out.printf("**                                                  **\n");
		System.out.printf("**         �I �� �` �M :  %2d                        **\n",total);
		System.out.printf("******************************************************\n");
	}//end rollDiceResult
	
	//�P�_�O�_������롦
	public boolean triples(){
		if(dice1==dice2 && dice2==dice3)
			return true;
		else
			return false;
	}//end triples

	//�P�_���j������Ĺ
	public void big(){
		if(total>=11 && total<=17 && triples()==false){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(bet);
		}
		else{
			System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end big

	//�P�_���p�� ��Ĺ
	public void small(){
		if(total>=4 && total<=10 && triples()==false){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(bet);
		}
		else{
			System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end small

	//�P�_�����򡦪���Ĺ
	public void anyTriples(){
		if(triples()==true){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*24) );
			System.out.printf("******************************************************\n");
			setProperty(bet*24);
		}
		else{
			System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end anyTriples

	//�P�_��������l������Ĺ
	public void twoDiceCombination(int guess1,int guess2){
		if(dice1 == guess1){
			if(dice2 == guess2 || dice3 == guess2){
				System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*5) );
				System.out.printf("******************************************************\n");
				setProperty(bet*5);
			}
			else{
				System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
				System.out.printf("******************************************************\n");
				setProperty(-bet);
			}	
		}
		else if(dice2 == guess1){
			if(dice1 == guess2 || dice3 == guess2){
				System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*5) );
				System.out.printf("******************************************************\n");
				setProperty(bet*5);
			}
			else{
				System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
				System.out.printf("******************************************************\n");
				setProperty(-bet);
			}	
		}
		else if(dice3 == guess1){
			if(dice1 == guess2 || dice2 == guess2){
				System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*5) );
				System.out.printf("******************************************************\n");
				setProperty(bet*5);
			}
			else{
				System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
				System.out.printf("******************************************************\n");
				setProperty(-bet);
			}	
		}
		else{
			System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end twoDiceCombination

	//�P�_�����롦����Ĺ
	public void specificDoubles(int guessTwo){
		if(dice1 == guessTwo && dice2 == guessTwo){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*8) );
			System.out.printf("******************************************************\n");
			setProperty(bet*8);
		}
		else if(dice2 == guessTwo && dice3 == guessTwo){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*8) );
			System.out.printf("******************************************************\n");
			setProperty(bet*8);
		}
		else if(dice1 == guessTwo && dice3 == guessTwo){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*8) );
			System.out.printf("******************************************************\n");
			setProperty(bet*8);
		}
		else{
			System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end specificDoubles

	//�P�_����롦����Ĺ
	public void specificTriples(int guessThree){
		if(dice1 == guessThree && dice2 == guessThree && dice3 == guessThree){
			System.out.printf("**     �� �� �z Ĺ �o :%4d ����                    **\n",(bet*150) );
			System.out.printf("******************************************************\n");
			setProperty(bet*150);
		}
		else{
			System.out.printf("**     �o �� �z �� �F :%4d ����                    **\n",bet);
			System.out.printf("******************************************************\n");
			setProperty(-bet);
		}
	}//end specificTriples

	//�Ǧ^�{�b�]��
	public int getProperty(){
		return property;
	}

	//�Ǧ^�Ĥ@����l�I��
	public int getDice1(){
		return dice1;
	}

	//�Ǧ^�ĤG����l�I��
	public int getDice2(){
		return dice2;
	}

	//�Ǧ^�ĤT����l�I��
	public int getDice3(){
		return dice3;
	}
}
