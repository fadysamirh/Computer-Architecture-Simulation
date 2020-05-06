
public class InstructionDecode {
	static boolean controlRegDst;
	static boolean controlBranch;
	static boolean controlMemRead;
	static boolean controlMemtoReg;
	static boolean controlALUOp1;
	static boolean controlALUOp0;
	static boolean controlMemWrite;
	static boolean controlALUSrc;
	static boolean controlRegWrite;
	
	static boolean useALU;
	static boolean useMem;
	static boolean useWB;
	
	
	static String opCode;
	static String readRegister1;
	static String readRegister2;
	static String writeRegister;
	
	
	
	static String signExtend;
	static String func;
	static String readData1;
	static String readData2;
	static String ALUOP;
	
	static String currInstruction;
	static int pcInt;
	static String nextpC;
	
	
	public static void InstDecode(){
		
		System.out.println();
		System.out.println("---------------------Starting decoding now---------------------");
		
		String instruction=currInstruction;
		
		opCode = instruction.substring(0, 4);
		
		ContUnit(opCode);
		String immValue;
		
		readRegister1 = instruction.substring(8, 12);
		
		readRegister2= instruction.substring(12,16);
		
		writeRegister= instruction.substring(4,8);	
		
		immValue=instruction.substring(8, 16);
		
		signExtend= SignExtend(immValue);//
		
		
		readData1= RegisterFile.getRegister(readRegister1);
		readData2= RegisterFile.getRegister(readRegister2);
		
		System.out.println("Loading Register no: " + (int)Long.parseLong(readRegister1,2) + " ,with address: "+ readRegister1);
		System.out.println("ReadData1 = " + readData1);
		System.out.println("Loading Register no: " + (int)Long.parseLong(readRegister2,2) + " ,with address: "+ readRegister2);
		System.out.println("ReadData2 = "+ readData2 );
		System.out.println("SignExtend = "+ signExtend +" ,with value of: " + (int)Long.parseLong(signExtend,2));
	}
		
	
	
	public static String SignExtend(String sixteenbit){
		
		String thirtyTwoBit = sixteenbit;
		for(int n=thirtyTwoBit.length(); n<16; n++) {
			if(thirtyTwoBit.startsWith("0")){
				thirtyTwoBit = "0" + thirtyTwoBit;
			}
			else{
				thirtyTwoBit = "1" + thirtyTwoBit;
			}
		}
		return thirtyTwoBit;
	}
	
	
	
	public static String ContUnit(String opCode){
		System.out.println("Control Unit:");
		if(opCode.equals("0000")){//add
			useALU=true;
			useMem= false;
			useWB= true;
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=true;
		} else if(opCode.equals("0001")){//SUB
			useALU=true;
			useMem= false;
			useWB= true;
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=true;
		} else if(opCode.equals("0010")){//MUL
			useALU=true;
			useMem= false;
			useWB= true;
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=true;
		} else if(opCode.equals("0011")){//OR
			useALU=true;
			useMem= false;
			useWB= true;
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=true;
		} else if(opCode.equals("0100")){//ADDI
			useALU=true;
			useMem= false;
			useWB= true;
			
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=true;
		} else if(opCode.equals("0101")){//AND IM
			useALU=true;
			useMem= false;
			useWB= true;
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=true;
		} else if(opCode.equals("0110")){ //SLL
			useALU=true;
			useMem= false;
			useWB= true;
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=true;
		} else if(opCode.equals("0111")){ //SLR
			
			useALU=true;
			useMem= false;
			useWB= true;
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=true;
		} 
		
		
		
		
		else if(opCode.equals("1010")){// BEQ
			controlRegDst=true;
			 controlBranch=true;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=false;
		} else if(opCode.equals("1011")){//BLT 
			controlRegDst=true;
			 controlBranch=true;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=false;
		} else if(opCode.equals("1100")){//store
			
			useALU=false;
			useMem= true;
			useWB= false;
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=true;
			 controlALUSrc=false;
			 controlRegWrite=true;
		} else if(opCode.equals("1101")){//load
			useALU=false;
			useMem= true;
			useWB= true;
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=true;
			 controlMemtoReg=true;
			 controlMemWrite=false;
			 controlALUSrc=false;
			 controlRegWrite=true;
		} else if(opCode.equals("1110")){//slti
			useALU=true;
			useMem= false;
			useWB= true;
			
			controlRegDst=true;
			 controlBranch=false;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=true;
		} else if(opCode.equals("1111")){//jump
			useALU=false;
			useMem= false;
			useWB= false;
			
			controlRegDst=true;
			 controlBranch=true;
			 controlMemRead=false;
			 controlMemtoReg=false;
			 controlMemWrite=false;
			 controlALUSrc=true;
			 controlRegWrite=false;
		} 
		
		
		
		
		
		
		
		System.out.println("ALU Controle set successfully and ALUOP= " + ALUOP);
		System.out.println();
		
		
		return ALUOP;
	}
	

}
