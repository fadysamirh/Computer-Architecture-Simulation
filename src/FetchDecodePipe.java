
public class FetchDecodePipe {

	static String currInstruction;
	static int pcInt;
	static String nextpC;

	public void getFetch() {
		this.currInstruction = InstructionFetch.curInstruction;
		this.pcInt = InstructionFetch.pcInt;
		this.nextpC = InstructionFetch.nextpC;
	}

	public void transferDecode() {
		InstructionDecode.currInstruction = this.currInstruction;
		InstructionDecode.pcInt = this.pcInt;
		InstructionDecode.nextpC = this.nextpC;
	}
}
