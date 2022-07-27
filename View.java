package view;


//설계툴 = 인터페이스
public interface View {
	public void showView();
	public boolean menuHandling(int menuNumber);
	
	default void wrongMenuSelected() {
		System.out.println("메뉴를 잘못 선택했습니다.");
		System.out.println("다시 선택해주세요.");
		
	}

}
