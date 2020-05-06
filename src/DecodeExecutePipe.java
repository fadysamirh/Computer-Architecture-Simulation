
public class DecodeExecutePipe {
	static boolean controlRegDst;
	static boolean controlBranch;
	static boolean controlMemRead;
	static boolean controlMemtoReg;
	static boolean controlALUOp1;
	static boolean controlALUOp0;
	static boolean controlMemWrite;
	static boolean controlALUSrc;
	static boolean controlRegWrite;
	
	static String opCode;
	static String readRegister1;
	static String readRegister2;
	static String writeRegister;
	
	static boolean useALU;
	static boolean useMem;
	static boolean useWB;
	
	static String signExtend;
	static String readData1;
	static String readData2;
	static String ALUOP;
	
	public void getDecode() {
		this.controlRegDst=InstructionDecode.controlRegDst;
		this.controlBranch=InstructionDecode.controlBranch;
		this.controlMemRead=InstructionDecode.controlMemRead;
		this.controlMemtoReg=InstructionDecode.controlMemtoReg;

		this.controlMemWrite=InstructionDecode.controlMemWrite;
		this.controlALUSrc=InstructionDecode.controlALUSrc;
		this.controlRegWrite=InstructionDecode.controlRegWrite;
		
		this.opCode=InstructionDecode.opCode;
		this.readRegister1=InstructionDecode.readRegister1;
		this.readRegister2=InstructionDecode.readRegister2;
		this.writeRegister=InstructionDecode.writeRegister;
		
		this.useALU=InstructionDecode.useALU;
		this.useMem=InstructionDecode.useMem;
		this.useWB=InstructionDecode.useWB;
		
		this.signExtend=InstructionDecode.signExtend;
		this.readData1=InstructionDecode.readData1;
		this.readData2=InstructionDecode.readData2;
		this.ALUOP=InstructionDecode.ALUOP;
	}
	public void transferExecute() {
		
		ExecuteClass.controlRegDst=this.controlRegDst;
		ExecuteClass.controlBranch=this.controlBranch;
		ExecuteClass.controlMemRead=this.controlMemRead;
		ExecuteClass.controlMemtoReg=this.controlMemtoReg;
		ExecuteClass.controlALUOp1=this.controlALUOp1;
		ExecuteClass.controlALUOp0=this.controlALUOp0;
		ExecuteClass.controlMemWrite=this.controlMemWrite;
		ExecuteClass.controlALUSrc=this.controlALUSrc;
		ExecuteClass.controlRegWrite=this.controlRegWrite;
		
		ExecuteClass.opCode=this.opCode;
		ExecuteClass.readRegister1=this.readRegister1;
		ExecuteClass.readRegister2=this.readRegister2;
		ExecuteClass.writeRegister=this.writeRegister;
		
		ExecuteClass.useALU=this.useALU;
		ExecuteClass.useMem=this.useMem;
		ExecuteClass.useWB=this.useWB;
		
		ExecuteClass.signExtend=this.signExtend;
		ExecuteClass.readData1=this.readData1;
		ExecuteClass.readData2=this.readData2;
		ExecuteClass.ALUOP=this.ALUOP;
		
	}
}
