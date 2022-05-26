-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Bulan Mei 2022 pada 06.02
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lampu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `lampu`
--

CREATE TABLE `lampu` (
  `id` int(11) NOT NULL,
  `nama_lampu` varchar(40) NOT NULL,
  `daya` varchar(40) NOT NULL,
  `tanggal` varchar(40) NOT NULL,
  `berat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `lampu`
--

INSERT INTO `lampu` (`id`, `nama_lampu`, `daya`, `tanggal`, `berat`) VALUES
(1, 'lampu tembak', '23 Watt', '2022-05-07', 300),
(2, 'Lampu Strip', '5 Watt', '2022-05-11', 30),
(3, 'Lampu Belajar', '18 Watt', '2022-05-11', 400),
(4, 'Lampu Bohlam', '15 Watt', '2022-05-10', 320);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `lampu`
--
ALTER TABLE `lampu`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
