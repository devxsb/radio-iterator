import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		String[] kanallar = { "JOYTURK", "TRT FM", "FENOMEN TURK", "ISTANBUL FM", "SLOW TURK" };
		Radio radio = new Radio(kanallar);

		Iterator<String> iterator = radio.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}

class Radio implements Iterable<String> {
	private ArrayList<String> kanalListesi = new ArrayList<String>();

	public Radio(String[] kanallar) {
		for (String kanal : kanallar) {
			kanalListesi.add(kanal);
		}
	}

	class radioIterator implements Iterator<String> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			if (index < kanalListesi.size()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public String next() {
			String deger = kanalListesi.get(index);
			index++;
			return deger;
		}

	}

	@Override
	public Iterator<String> iterator() {
		return new radioIterator();
	}

}