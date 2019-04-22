package block.pk;

public class block {
	
	public	int index;
	public	String previous_hash;
	public	String hash;
	public	String data;

	public	block() {
			this.index = 0;
			this.previous_hash = "0";
			this.data = "Welcome to block 0";
			this.hash = "0";
	}
	public block(int _index, String _previous_hash, String _hash, String _data)
		{
			this.index = _index;
			this.previous_hash = _previous_hash;
			this.data = _data;
			this.hash = _hash;
	}

	public String getHash() {
		String hash_input = Integer.toString(this.index) + this.previous_hash + this.data;
		return hash_input.substring(0, 4);
	}
	
	
	public static block getGenesisBlock() {
		sha256 cryp = new sha256();
		String data = "Block genesis index 0";
		String previous_hash = "0";
		String hash = cryp.getHash(Integer.toString(0) + previous_hash + data);
		hash = hash.substring(0, 4);
		block bl = new block(0, previous_hash, hash, data);
		return bl;
	}
	public static block getBlock(block previous_block, String data) {
		sha256 cryp = new sha256();
		int index = previous_block.index + 1;
		String previous_hash = previous_block.hash;
		
		String hash = cryp.getHash(Integer.toString(index) + previous_hash + data);
		hash = hash.substring(0, 4);
		block bl = new block(index, previous_hash, hash, data);
		return bl;
	}
	
	public boolean isValidNewBlock (block new_block, block previous_block) {
	    if (previous_block.index + 1 != new_block.index) {
	        System.out.println("invalid index");
	        return false;
	    } else if (previous_block.hash.compareTo(new_block.previous_hash) != 0) {
	    	System.out.println("invalid previous hash");
	        return false;
	    } else if (new_block.getHash().compareTo(new_block.hash) != 0) {
	    	System.out.println("invalid hash: " + new_block.getHash() + " " + new_block.hash);
	        return false;
	    }
	    return true;
	};

	public void PrintBlock() {
		System.out.print("Block: " + this.index);
		System.out.print(", P-hash: " + this.previous_hash);
		System.out.print(", Data: " + this.data);
		System.out.println(", Hash: " + this.hash);
		
		
	}
	
	public static void PrintBlockchain(block [] blockchain)
	{
		for (int i = 0; i < blockchain.length; i++) {
			System.out.println("Block: " + blockchain[i].index + " (" + blockchain[i].hash + ")");
			System.out.println("|");
			System.out.println("v");
			
		}
	}
};



