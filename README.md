I. Pendahuluan

Di era digital saat ini, kebutuhan untuk mengonversi mata uang sangat penting, baik untuk kebutuhan bisnis, perjalanan, maupun belanja online. Pada artikel ini, saya akan membagikan cara membuat aplikasi sederhana Currency Converter menggunakan Jetpack Compose di Android Studio. Aplikasi ini memiliki tampilan menarik dengan latar belakang warna pink dan nama pembuat yang tercantum di dalam aplikasi.

II. Langkah-Langkah Pembuatan

Membuat Project Baru
Pilih New Project: Empty Compose Activity
Nama Project: CurrencyConverter
Bahasa: Kotlin
    2. Membuat UI Aplikasi
1. MainActivity.kt — Entry Point Aplikasi
```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurencyConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverterUI()
                }
            }
        }
    }
}
```
Penjelasan:

- MainActivity adalah titik masuk utama aplikasi Android.
- setContent { ... } digunakan dalam Jetpack Compose untuk menentukan layout UI.
- CurencyConverterTheme { ... } adalah custom tema Compose (yang kamu definisikan sendiri).
- Surface(...) { CurrencyConverterUI() } membungkus UI agar mengikuti tema dan padding dasar.
- CurrencyConverterUI() adalah fungsi komponen UI utama.

2. CurrencyConverterUI() — Komponen UI Utama
```
@Composable
fun CurrencyConverterUI() {
```
Fungsi ini adalah komponen Compose yang menampilkan UI dari aplikasi.

Variabel State:
- var dollarInput by remember { mutableStateOf("") }
- var result by remember { mutableStateOf("") }
- val conversionRate = 16851.0
- dollarInput: menyimpan input dari pengguna.
- result: menyimpan hasil konversi.
- conversionRate: nilai tukar tetap dari USD ke IDR (Rp 16.851).

Struktur Layout:
```
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
        .background(Color(0xFFFFC0CB)), // Warna pink
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
```
Penjelasan:
- Menggunakan Column untuk menata elemen secara vertikal.
- padding(24.dp) memberikan ruang di sekeliling konten.
- background(Color(0xFFFFC0CB)) memberi warna latar pink.

Judul Aplikasi: Menampilkan judul aplikasi dengan ukuran besar dan warna biru.
```
Text(
    text = "Currency App",
    fontSize = 28.sp,
    fontWeight = FontWeight.Bold,
    color = Color(0xFF1565C0)
)
```

Kredit Nama: Menambahkan identitas pembuat aplikasi di bawah judul.
```
Text(
    text = "by : Yasmin Putri",
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    color = Color.DarkGray
)
```

Deskripsi Konversi: Deskripsi mata uang yang dikonversi, ditampilkan dengan emoji dan gaya bold.
```
Text(
    text = "🇺🇸 USD → 🇮🇩 IDR",
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium,
    color = Color(0xFF0D47A1)
)
```

Label Input: Label untuk memberi tahu pengguna apa yang harus diinput.
```
Text(
    text = "Enter USD amount",
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    color = Color(0xFF1565C0),
    modifier = Modifier
        .align(Alignment.Start)
        .padding(bottom = 4.dp)
)
```

Input dan Icon:
```
Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth()
) {
    Text(
        text = "💲",
        fontSize = 26.sp,
        modifier = Modifier.padding(end = 8.dp)
    )

    OutlinedTextField(
        value = dollarInput,
        onValueChange = { dollarInput = it },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.weight(1f)
    )
}
```
- 💲: Ikon mata uang untuk estetika.
- OutlinedTextField: Tempat pengguna mengetik jumlah USD.
- keyboardType = KeyboardType.Number: Hanya angka yang bisa diketik.

Tombol Convert:
```
Button(
    onClick = {
        val value = dollarInput.toDoubleOrNull()
        result = if (value != null) {
            "Rp ${"%,.2f".format(value * conversionRate)}"
        } else {
            "Invalid input"
        }
    },
    modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
) {
    Text("Convert", fontSize = 18.sp, color = Color.White)
}
```
Penjelasan:

- Saat tombol ditekan, input dikonversi ke Double.
- Jika valid, maka dihitung dan diformat ke format IDR dengan 2 desimal dan pemisah ribuan.
- Jika tidak valid, tampilkan pesan “Invalid input”.

Hasil Konversi: Menampilkan hasil hanya jika nilai result tidak kosong.
```
if (result.isNotEmpty()) {
    Text(
        text = result,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF0D47A1)
    )
}
```

🔚 Kesimpulan
Kode ini membuat aplikasi konversi mata uang USD ke IDR dengan UI berbasis Compose yang simpel namun menarik. Kamu menggunakan:
- State management sederhana (remember & mutableStateOf)
- Layout dengan Column dan Row
- Form input (OutlinedTextField)
- Konversi angka dan formatting currency
- Tampilan warna pink sebagai identitas visual

Hasil Akhir 
Dengan mengikuti langkah-langkah di atas dapat membuat aplikasi konversi mata uang USD ke IDR dengan tampilan menarik dan fitur dasar yang berfungsi dengan baik. Aplikasi ini sangat cocok sebagai proyek pemula untuk belajar Jetpack Compose dan Kotlin Android.
