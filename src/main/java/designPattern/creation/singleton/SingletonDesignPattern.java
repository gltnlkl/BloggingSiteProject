package designPattern.creation.singleton;

public class SingletonDesignPattern {

	// 1. adım instance class nesnesi
	private static SingletonDesignPattern instance;

	// 2. adım private constractor
	private SingletonDesignPattern() {
	}

	// 3. adım static public bir getter ( obje olusturma methodu )
	// nesne olusturulmamıs ıse olustur, nesne var ise mevcutu gonderır.
	public static SingletonDesignPattern getInstance() {

		if (instance == null) {
			instance = new SingletonDesignPattern();
		}
		return instance;

	}

}
