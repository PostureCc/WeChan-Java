-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.48 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 chan_test 的数据库结构
CREATE DATABASE IF NOT EXISTS `chan_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `chan_test`;

-- 导出  表 chan_test.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `SNO` varchar(3) NOT NULL,
  `SNAME` varchar(4) NOT NULL,
  `SSEX` varchar(2) NOT NULL,
  `SBIRTHDAY` datetime DEFAULT NULL,
  `CLASS` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- 正在导出表  chan_test.student 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`SNO`, `SNAME`, `SSEX`, `SBIRTHDAY`, `CLASS`) VALUES
	('108', '曾华', '男', '1977-09-01 00:00:00', '95033'),
	('105', '匡明', '男', '1975-10-02 00:00:00', '95031'),
	('107', '王丽', '女', '1976-01-23 00:00:00', '95033'),
	('101', '李军', '男', '1976-02-20 00:00:00', '95033'),
	('109', '王芳', '女', '1975-02-10 00:00:00', '95031'),
	('103', '陆君', '男', '1974-06-03 00:00:00', '95031');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
