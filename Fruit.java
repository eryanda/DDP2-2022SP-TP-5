public class Fruit extends Product {
    // Atribut spesifik untuk kelas Fruit
    private boolean isLocal; // Merupakan sebuah penanda apakah buah tersebut merupakan produk lokal atau bukan.

    // Konstruktor untuk kelas Fruit
    public Fruit(String nama, int price, int stock, boolean isLocal) {
        super(nama, price, stock);
        this.isLocal = isLocal;
    }

    // Method untuk memeriksa dan memberikan diskon berdasarkan kuantitas dan status lokal atau impor
    @Override
    public int checkDiscount(int quantity) {
        if (isLocal) {
            if (quantity >= 5) {
                return 30; // Diskon 30% untuk pembelian buah lokal minimal 5 kg
            } else if (quantity >= 3) {
                return 20; // Diskon 20% untuk pembelian buah lokal minimal 3 kg
            }
        } else {
            if (quantity >= 5) {
                return 20; // Diskon 20% untuk pembelian buah impor minimal 5 kg
            } else if (quantity >= 3) {
                return 15; // Diskon 15% untuk pembelian buah impor minimal 3 kg
            }
        }
        return 0; // Tidak ada diskon jika kuantitas tidak mencukupi
    }

    // Getter dan Setter untuk atribut isLocal
    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }
}
