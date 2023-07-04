
public class Income {
	String source;
	double amount;
	String Month;

	public Income (String src, double amnt, String Mnth){
		this.source = src;
		this.amount = amnt;
		this.Month = Mnth;
	}
	public Income(){
		this.source = "default";
		this.amount = 0;
		this.Month = "default";
	}
	//should add contructor(s)
}
