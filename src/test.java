
public class test {
	public static void main(String [] args){
		String instruction = "10000000001";
		String x =ExecuteClass.srl(instruction,3);

		System.out.println(Engine.to16Bits(instruction));
		System.out.println(x);
		
	}

}
