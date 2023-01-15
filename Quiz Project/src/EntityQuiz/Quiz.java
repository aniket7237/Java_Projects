package EntityQuiz;


public class Quiz {
	
     String Questions;
     String A;
     String B;
     String C;
     String D;
     String Correct_ans;
	public String getQuestions() {
		return Questions;
	}
	public void setQuestions(String questions) {
		Questions = questions;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	} 
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public String getCorrect_ans() {
		return Correct_ans;
	}
	public void setCorrect_ans(String correct_ans) {
		Correct_ans = correct_ans;
	}
	@Override
	public String toString() {
		return "Quiz [Questions=" + Questions + ", A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", Correct_ans="
				+ Correct_ans + "]";
	}
     
}
