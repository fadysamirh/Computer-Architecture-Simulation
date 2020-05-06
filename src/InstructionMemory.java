import java.util.ArrayList;

public class InstructionMemory {
	static String pC = "0";
	static int pCInt = 0;
	private static ArrayList<String> pInstructions;

	public InstructionMemory() {
		pC = "00000000000000000000000000000000";
	}

	public static String getInstruction(String pCAddress) {
		pCInt = Integer.parseInt(pCAddress, 2);
		if (pCInt >= pInstructions.size()) {
			return null;
		} else {
			return pInstructions.get(pCInt);
		}
	}

	public static void loadInstructions(ArrayList<String> Instructions) {
		pInstructions = new ArrayList<String>();

		for (int i = 0; i < Instructions.size(); i++) {
			if (Instructions.get(i).length() == 16)
				pInstructions.add(Instructions.get(i));
			else {
				System.out.println("Wrong Instruction length at index " + i);
				System.out.println("The program will now end");
				return;
			}
		}

		System.out.println("Intructions are now loaded to the instruction memory");
		boolean done = false;
		int cc = 1; // current clock cycle
		int tcc = pInstructions.size() +4; // total clock cycles

		while (cc <= tcc ) {

			System.out.println("The PC is " + pCInt);

			if (cc >= 1) {
				
				if(cc<=tcc)
				if (cc >= 5) {
					MemWritePipe.transferWrite();

					WriteBackClass.WriteBack();
				}
				if(cc<=tcc-1)
				if (cc >= 4) {
					ExecuteMemPipe.transferMem();

					MemoryAccess.memAccess();
				}
				if(cc<=tcc-2)
				if (cc >= 3) {
					DecodeExecutePipe.transferExecute();
					ExecuteClass.Execute();
				}
				if(cc<=tcc-3)
				if (cc >= 2) {
					FetchDecodePipe.transferDecode();
					InstructionDecode.InstDecode();
				}
				if(cc<=tcc-4){
					InstructionFetch.InstFetch(pC);
				}
			
				
			}

			cc++; // incrementing clock cycle
		}

	}

	public static String to16Bits(String old) {

		String thirtyTwoBit = old;
		for (int n = thirtyTwoBit.length(); n < 16; n++) {
			thirtyTwoBit = "0" + thirtyTwoBit;

		}
		return thirtyTwoBit.substring(thirtyTwoBit.length() - 16, thirtyTwoBit.length());
	}

	public static String to32Bits(String old) {

		String thirtyTwoBit = old;
		for (int n = thirtyTwoBit.length(); n < 32; n++) {
			if (thirtyTwoBit.substring(0, 1).equals("0")) {
				thirtyTwoBit = "0" + thirtyTwoBit;
			} else {
				thirtyTwoBit = "1" + thirtyTwoBit;
			}
		}
		return thirtyTwoBit;
	}

	public static void main(String[] args) {

		ArrayList<String> instructions = new ArrayList<String>();

		// add
		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(10));
		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(5));
		instructions.add("0000001100100001");

//		sub
		RegisterFile.arrRegister[4] = to16Bits(Integer.toBinaryString(-2));
		RegisterFile.arrRegister[5] = to16Bits(Integer.toBinaryString(10));
		instructions.add("0001011001000101");

//		mult
		RegisterFile.arrRegister[4] = to16Bits(Integer.toBinaryString(-2));
		RegisterFile.arrRegister[5] = to16Bits(Integer.toBinaryString(10));
		instructions.add("0010011001000101");

////		or
//		RegisterFile.arrRegister[4] = "0000000000000000";
//		RegisterFile.arrRegister[5] = "1010101010101010";
//		instructions.add("0011011001000101");
//
////		addi
//		RegisterFile.arrRegister[6] = to16Bits(Integer.toBinaryString(10));
//		instructions.add("0100011000000101");
//
////		andi
//		RegisterFile.arrRegister[6] = "0101010101010101";
//		instructions.add("0101011011111111");
//
////		SLL
//		RegisterFile.arrRegister[6] = "0000000000000001";
//		instructions.add("0110011000000011");
//
////		SLR
//		RegisterFile.arrRegister[6] = "0000000000100000";
//		instructions.add("0111011000000011");
//
//		// load
//		DataMemory.dataList[4] = "1111";
//		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(1));
//		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(3));
//		instructions.add("1101001100010010");
//
////		//store
//		RegisterFile.arrRegister[6] = to16Bits(Integer.toBinaryString(20));
//		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(1));
//		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(3));
//		instructions.add("1100001100010010");
//
//		// beq
//		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(5));
//		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(20));
//		RegisterFile.arrRegister[3] = to16Bits(Integer.toBinaryString(20));
//		instructions.add("1010000100100011");
//
//		// BLT
//		RegisterFile.arrRegister[1] = to16Bits(Integer.toBinaryString(5));
//		RegisterFile.arrRegister[2] = to16Bits(Integer.toBinaryString(1));
//		RegisterFile.arrRegister[3] = to16Bits(Integer.toBinaryString(2));
//		instructions.add("1011000100100011");
//
//		// jump
//		instructions.add("1111000000000011");

		// error instruction
//		instructions.add("10101000000000000000000000000001");

		InstructionMemory.loadInstructions(instructions); // this method runs the data path (loads and executes all
															// instructions)

	}

}
