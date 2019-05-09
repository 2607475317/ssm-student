/*
 Navicat Premium Data Transfer

 Source Server         : king
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : ssmstudent

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 20/03/2019 08:17:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (1, '软件技术');
INSERT INTO `t_class` VALUES (2, '云计算');
INSERT INTO `t_class` VALUES (3, '软件信息与服务');
INSERT INTO `t_class` VALUES (4, '网络技术');
INSERT INTO `t_class` VALUES (5, '计算机应用');
INSERT INTO `t_class` VALUES (6, '应用电子');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` bigint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pwd` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `stunum` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imgUrl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `classid` bigint(20) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `classid`(`classid`) USING BTREE,
  CONSTRAINT `classid` FOREIGN KEY (`classid`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '西门吹雪', '', '20172523001', '/student/uploadFile/b949bcfb-96e3-4cf5-8e64-4609c19b5aaa.null', 2, b'0');
INSERT INTO `t_student` VALUES (3, '狗不理', 'xxxxxx', '20172523004', 'uploadFile/b.jpg', 3, b'0');
INSERT INTO `t_student` VALUES (4, '蛇姑娘', 'xxxxxx', '20172523005', 'uploadFile/d.jpg', 2, b'0');
INSERT INTO `t_student` VALUES (5, '鸡大姐', 'xxxxxx', '20172523022', '/student/uploadFile/d1d41519-608f-4196-910a-db82f439f350.jpg', 5, b'1');
INSERT INTO `t_student` VALUES (6, '任我行', '123456', '20172523065', 'uploadFile/2.png', 2, b'1');
INSERT INTO `t_student` VALUES (7, '欧阳锋', '123456', '20172523002', 'uploadFile/3.png', 3, b'0');
INSERT INTO `t_student` VALUES (8, '郭靖', 'gggggg', '20172523099', 'uploadFile/4.png', 2, b'0');
INSERT INTO `t_student` VALUES (9, '张三丰', 'zzzzzz', '20172523078', 'uploadFile/5.png', 3, b'1');
INSERT INTO `t_student` VALUES (10, '杨过', 'yyyyyy', '20172523035', 'uploadFile/6.png', 3, b'1');
INSERT INTO `t_student` VALUES (11, '东方不败', 'dddddd', '20172523047', 'uploadFile/7.png', 4, b'1');
INSERT INTO `t_student` VALUES (12, '任盈盈', 'rrrrrr', '20172523025', 'uploadFile/8.png', 3, b'0');
INSERT INTO `t_student` VALUES (13, '令狐冲', 'llllll', '20172523045', 'uploadFile/1.png', 5, b'1');
INSERT INTO `t_student` VALUES (14, '岳不群', 'yyyyyy', '20172523003', 'uploadFile/2.png', 6, b'1');
INSERT INTO `t_student` VALUES (15, '沙师弟', 'ssssss', '20172523033', NULL, 1, b'1');
INSERT INTO `t_student` VALUES (28, '猴师兄', 'hhhhhh', '20172523028', '/student/uploadFile/1d8bceaa-24ee-404f-ba03-4eaba76e8ec2.jpg', 1, b'1');

SET FOREIGN_KEY_CHECKS = 1;
