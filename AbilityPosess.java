package paket;

import java.util.LinkedList;

public class AbilityPosess extends Ability{
	
	private int range;
	private int time;
	
	public AbilityPosess(int range, int time) {
		
		this.range = range;
		this.time = time;
		
	}

	public void useFunction() {
		
		LinkedList<Creature> validTargets;
		validTargets = Handler.filter(Creature.class);
		
	}

}
