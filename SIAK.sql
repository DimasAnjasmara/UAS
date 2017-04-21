-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 22. April 2017 jam 03:16
-- Versi Server: 5.1.37
-- Versi PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `SIAK`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_matkul`
--

CREATE TABLE IF NOT EXISTS `tbl_matkul` (
  `kode_mk` int(10) NOT NULL DEFAULT '0',
  `Nama_mk` varchar(30) DEFAULT NULL,
  `Sks` int(3) DEFAULT NULL,
  PRIMARY KEY (`kode_mk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_matkul`
--

INSERT INTO `tbl_matkul` (`kode_mk`, `Nama_mk`, `Sks`) VALUES
(101101, 'Agama', 2),
(101102, 'Data Base', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_mhs`
--

CREATE TABLE IF NOT EXISTS `tbl_mhs` (
  `Nim` int(10) NOT NULL DEFAULT '0',
  `Nama` varchar(20) DEFAULT NULL,
  `Lahir` date DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Nim`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_mhs`
--

INSERT INTO `tbl_mhs` (`Nim`, `Nama`, `Lahir`, `Alamat`) VALUES
(1641803, 'Dimas Anjasmara', '1994-04-26', 'Babakan Ciparay'),
(1641804, 'Lukman Kurniawan', '1994-01-23', 'Sukamulya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_nilai`
--

CREATE TABLE IF NOT EXISTS `tbl_nilai` (
  `Nim` int(10) NOT NULL DEFAULT '0',
  `kode_mk` int(10) NOT NULL DEFAULT '0',
  `Nilai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Nim`,`kode_mk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_nilai`
--

INSERT INTO `tbl_nilai` (`Nim`, `kode_mk`, `Nilai`) VALUES
(1641803, 101101, 'A'),
(1641804, 101102, 'B');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
