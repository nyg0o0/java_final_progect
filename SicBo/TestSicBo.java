 /** SicBo game
 *   Variables List - 
 *     userName: ���a�W�ٿ�J
 *     roundNumber: �p��^�X��
 *     property: �]��
 *
 */

import java.util.Scanner;

public class TestSicBo {

	/** Main method */
	public static void main(String[] args){
		
		//�L�X�C���W�ٻP�W�h
		System.out.println("\n���_");
		System.out.println("******************************************************************************");
		System.out.println("* �C���W�h�G                                                                 *");
		System.out.println("*                                                                            *");
		System.out.println("* ��.���a�@�}�l��5000���ꥻ�A�i�@������S�ꥻ����C                          *");
		System.out.println("*                                                                            *");

		System.out.println("* ��.�q���O���a�A�C�@�����a�|��T����l�A���a�̦ۤv�N�@�i���ƤU�`�C  �@      *");
		System.out.println("*    �U�`�����H�γӥX��k�p�U�G                                              *");
		System.out.println("*                                                                            *");
		System.out.println("*�@  (1)�j�G�`�I�Ƭ�11��17�A�����]�t��몬�p�]�T����Ҭ�4��5��6�^            *");
		System.out.println("*�@  (2)�p�G�`�I�Ƭ�4��10�A�����]�t��몬�p�]�T����Ҭ�1��2��3�^             *");
		System.out.println("*�@  (3)����]�\�l�^�G�����w�I�ơA�T����l�I�ƥ��P                           *");
		System.out.println("*�@  (4)������l�G�q����X����l�䤤�������զX�A�ӳo������l���I�Ƥ��@��     *");
		System.out.println("*�@  (5)����G�q����X����l�䤤�������զX�A�ӳo������l���I�Ƥ@��           *");
		System.out.println("*�@  (6)���G���w�I�ơA�T����l�I�ƥ��P�]�Ҧp:��@�B�@�\�l�^                *");
		System.out.println("*                                                                            *");

		System.out.println("* ��.�U�U�`�������߲v�G                                                      *");
		System.out.println("*�@   �ССССССССССССССССССССССССССССССССС�   *");
		System.out.println("*�@  �U�@�@�j�@�@|�@�@�p�@�@| ������l |�@ ���� �@|�@ ���� �@|�@ ��� �@ �U  *");
		System.out.println("*�@  �U�ССССССССССССССССССССССССССССССС�  �U  *");
		System.out.println("*�@  �U�@ 1��1 �@|�@ 1��1 �@|�@ 1��5 �@|�@ 1��8 �@|�@ 1��24�@|�@1��150�@ �U  *");
		System.out.println("*�@   �ССССССССССССССССССССССССССССССССС�   *");
		System.out.println("******************************************************************************");

		//�Ȼs�ƪ��a�W��,���w�缾�a�i�J�C��
		System.out.print("�п�J���a�W��: ");
		Scanner input = new Scanner(System.in);
		String userName = input.nextLine();
		System.out.println("");
		System.out.println("------------ �w�� " + userName +" �Ө�V�Y������� ------------");
		System.out.println("");

		//��l��:�O�_�n�A���@��,�w������,�]��
		boolean repeatGame = false;
		int roundNumber = 1;
		int bets=0;
		int sale=0;
		SicBo game = new SicBo();
		if ( userName.equals("�V�Y�����N�O�n��") ){
			game.initialProperty(50000);
		}
		else{
			game.initialProperty(5000);
		}


		//�}�l�C��		
		do{
			System.out.println("�z�ثe���]��: " + game.getProperty() );
			//�L�X�ӧ���,�Ъ��a��J������B
			do{
				System.out.print("��" + roundNumber + "��, �п�J������`���B: ");
				bets = input.nextInt();
				game.bet(bets);
				if(game.getProperty() == 0){
					System.out.println("�ܩ�p!�z�w�g�}���F!");
					System.out.print("��ǥi��o5000���A�n���? (y/n) ");
					Scanner ask = new Scanner(System.in);
					String askStr = ask.nextLine();
					if ( askStr.equals("y") && sale<2 ){
						System.out.println("�w��F"+(sale+1)+"���ǡA�o��5000��");
						game.initialProperty(5000);
						sale++;
					}
					else if(sale>=2){
						System.out.println("�ܩ�p!�z�w�g�}���F!");
						System.out.println("2���Ǥ]����F!!");
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
					System.out.println("�ܩ�p!�z���]���S���o��h!");
				}
			}while(game.getProperty() < bets);

			//�p�G�w�g��F2���ǡA�h���X
			if(sale>2)
				break;

			//�Ъ��a��J���@���ﶵ
			System.out.print("\n�аݭn����ӿﶵ? (1)�j, (2)�p, (3)����]�\�l�^, (4)������l, (5)����, (6)���\n�z����ܬO: ");
			int choose = input.nextInt();

			//�w����@�ﶵ,�i�J����_class���������ﶵ,�ݨ��Ĺ
			switch(choose){
				//��ܽ�u�j�v
				case 1: 
					System.out.println("�z��ܪ��O��u�j�v");
					game.rollDice();
					game.rollDiceResult();
					game.big();
					break;

				//��ܽ�u�p�v
				case 2: 
					System.out.println("�z��ܪ��O��u�p�v");
					game.rollDice();
					game.rollDiceResult();
					game.small();
					break;


				//��ܽ�u����v
				case 3: 
					System.out.println("�z��ܪ��O��u����]�\�l�^�v");
					game.rollDice();
					game.rollDiceResult();
					game.anyTriples();
					break;
 
				//��ܽ�u������l�v
				case 4: 
					System.out.println("�z��ܪ��O��u������l�v");
					System.out.print("�п�J�Ĥ@�ӻ�l�I��: ");
					int guess1 = input.nextInt();
					System.out.println("");
					System.out.print("�п�J�ĤG�ӻ�l�I��: ");
					int guess2 = input.nextInt();
					System.out.println("");
					game.rollDice();
					game.rollDiceResult();
					game.twoDiceCombination(guess1,guess2);
					break;

				//��ܽ�u����v
				case 5: 
					System.out.println("�z��ܪ��O��u����v");
					System.out.print("�п�J���몺�I��: ");
					int guessTwo = input.nextInt();
					System.out.println("");
					game.rollDice();
					game.rollDiceResult();
					game.specificDoubles(guessTwo);
					break;

				//��ܽ�u���v
				case 6: 
					System.out.println("�z��ܪ��O��u���v");
					System.out.print("�п�J��몺�I��: ");
					int guessThree = input.nextInt();
					System.out.println("");
					game.rollDice();
					game.rollDiceResult();
					game.specificDoubles(guessThree);
					break;

				default:
			}//end switch

			//��ܹ��e���]��
			System.out.printf("**     �z �� �l �� �] �� : %7d  ����            **\n",game.getProperty());
			System.out.printf("******************************************************\n");
			roundNumber++;//�����@��,���ƥ[�@

			//�߰ݪ��a�O�_�n�A���@��
			System.out.print("�٭n�A�Ӥ@����? (y/n) ");
			Scanner input2 = new Scanner(System.in);
			String playAgainStr = input2.nextLine();
			System.out.println("");
			if ( playAgainStr.equals("y") ){
				repeatGame = true;
			}
			else{
				repeatGame = false;
			}

		}while( repeatGame == true );//�A���@��
	}
}