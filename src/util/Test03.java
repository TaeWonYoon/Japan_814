package util;

import javax.swing.JOptionPane;

public class Test03 {

	public static void main(String[] args) {

		Command insert = new Command() {
			@Override
			public void exac() {
				// TODO Auto-generated method stub
				System.out.println("Insert");
			}
		};
		
		Command update = new UpdateCommand();
		
		Command delete = () -> {
			System.out.println("delete");
		};
		
		String cmd = JOptionPane.showInputDialog("1.insert, 2.delete, 3.update, 4.quit");

		switch (cmd) {
		case "1":
			insert.exac();
			break;
		case "2":
			delete.exac();
			break;
		case "3":
			update.exac();
			break;
		case "4":
			break;
		default:
			System.out.println("메뉴선택이 잘못입력했습니다.");
			break;
		}
		
	}
	
}

@FunctionalInterface
interface Command {
	abstract void exac();
}

class DeleteCommand implements Command {
	public void exac() {
		System.out.println("deletedate");
	}
}

class UpdateCommand implements Command {
	public void exac() {
		System.out.println("UPdate");
	}
}
