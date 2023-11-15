-- Tạo cơ sở dữ liệu
CREATE DATABASE QuanLyThueXe;
USE QuanLyThueXe;

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    MaNV varchar(5) NOT NULL,
    MatKhau varchar(50) NOT NULL,
    TenNV nvarchar(225) NOT NULL,
    GioiTinh bit NOT NULL,
	SDT varchar (20) NOT NULL,
    Email nvarchar(225) NOT NULL,
    VaiTro bit NOT NULL,
	Hinh varchar(225),
    CONSTRAINT PK_NhanVien PRIMARY KEY (MaNV)
);

-- Tạo bảng KhachHang*


CREATE TABLE KhachHang (
    MaKH int IDENTITY(1, 1) NOT NULL,
    TenKH nvarchar(225) NOT NULL,
	CCCD varchar(20) NOT NULL,
    GioiTinh bit NOT NULL,
    DiaChi nvarchar(225) NOT NULL,
    SDT varchar(50) NOT NULL,
    MaNV varchar(5) NOT NULL,
	CONSTRAINT PK_KhachHang PRIMARY KEY (MaKH),
    CONSTRAINT FK_KhachHang_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- Tạo bảng LoaiXe
CREATE TABLE LoaiXe (
    MaLoai varchar(10) NOT NULL,
    TenLoai nvarchar(50) NOT NULL,
    CONSTRAINT PK_LoaiXe PRIMARY KEY (MaLoai) 
);

-- Tạo bảng ThongTinXe
CREATE TABLE ThongTinXe (
    MaXe int IDENTITY(1,1) NOT NULL,
    TenXe nvarchar(50) NOT NULL,
    SoLuong INT NOT NULL,
    Hinh varchar(100),
    MaNV varchar(5) NOT NULL,
	MaLoai varchar(10) NOT NULL,
	CONSTRAINT PK_ThongTinXe PRIMARY KEY (MaXe),
    CONSTRAINT FK_Xe_NhanVien FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
	CONSTRAINT FK_Xe_Loai FOREIGN KEY (MaLoai) REFERENCES LoaiXe(MaLoai) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- Tạo bảng HoaDon
CREATE TABLE HoaDon (
    MaHD varchar(10) NOT NULL,
    MaKH int NOT NULL,
	MaNV varchar(5) NOT NULL,
	NgayTao Date NOT NULL,
	TrangThai nvarchar(50) NOT NULL,
    TongTien money ,
	CONSTRAINT PK_HoaDon PRIMARY KEY (MaHD),
    CONSTRAINT FK_HD_KH FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_HD_NV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) 
);

-- Tạo bảng HoaDonChiTiet
CREATE TABLE HoaDonChiTiet (
    MaHDCT int IDENTITY(1,1) NOT NULL,
    MaXe int NOT NULL,
	MaHD varchar(10) NOT NULL,
    SoLuongThue int NOT NULL,
    NgayDat date NOT NULL,
    NgayTra date NOT NULL,
	GiaThue Money NOT NULL,
	GhiChu nvarchar(225) ,
    CONSTRAINT PK_HoaDonChiTiet PRIMARY KEY (MaHDCT),
    CONSTRAINT FK_CT_MX FOREIGN KEY (MaXe) REFERENCES ThongTinXe(MaXe) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT FK_CT_HD FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD) ON DELETE NO ACTION ON UPDATE CASCADE
);

Go
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [SDT], [Email], [VaiTro]) VALUES (N'NV001', N'123456', N'Phan Thanh Tân', 1, '0707308240', N'phanthanhtan2102@gmail.com', 1)
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [GioiTinh], [SDT], [Email], [VaiTro]) VALUES (N'NV002', N'123456', N'Nguyễn Thị Yến Nhi', 0, '0930219676', N'yennhi@gmail.com', 1)


SET IDENTITY_INSERT [dbo].[KhachHang] ON 
INSERT [dbo].[KhachHang]([MaKH], [TenKH], [CCCD], [GioiTinh], [DiaChi], [SDT], [MaNV]) VALUES (1, N'Nguyễn Trung Tín', '092099001433', 1, N'Hậu Giang', '0707308241', 'NV001')
INSERT [dbo].[KhachHang]([MaKH], [TenKH], [CCCD], [GioiTinh], [DiaChi], [SDT], [MaNV]) VALUES (2, N'Lê Trọng Hiếu', '092099001422', 1, N'Cần Thơ', '0707308244', 'NV001')
INSERT [dbo].[KhachHang]([MaKH], [TenKH], [CCCD], [GioiTinh], [DiaChi], [SDT], [MaNV]) VALUES (3, N'Trần Thị Nhã', '092099001122', 0, N'Đồng Tháp', '0707308214', 'NV001')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF

Go
INSERT [dbo]. [LoaiXe]([MaLoai],[TenLoai]) VALUES ('4C', N'4 Chỗ')


SET IDENTITY_INSERT [dbo].[ThongTinXe] ON 
INSERT [dbo]. [ThongTinXe]([MaXe], [TenXe], [SoLuong], [Hinh], [MaNV], [MaLoai]) VALUES (1, 'Honda CiVic', 4, '', 'NV001', '4c')
SET IDENTITY_INSERT [dbo].[ThongTinXe] OFF

SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 
INSERT [dbo].[HoaDonChiTiet]([MaHDCT],[MaHD],[MaXe],[NgayDat],[NgayTra],[SoLuongThue],[GiaThue],[GhiChu]) VALUES(1,'HD001',1,'2023-11-02','2023-11-10',4,'600000', N'4000KM - Trầy nhẹ bên cửa phụ')
INSERT [dbo].[HoaDonChiTiet]([MaHDCT],[MaHD],[MaXe],[NgayDat],[NgayTra],[SoLuongThue],[GiaThue],[GhiChu]) VALUES(2,'HD002',1,'2023-09-12','2023-09-20',2,'600000', N'5000KM')
INSERT [dbo].[HoaDonChiTiet]([MaHDCT],[MaHD],[MaXe],[NgayDat],[NgayTra],[SoLuongThue],[GiaThue],[GhiChu]) VALUES(3,'HD003',1,'2023-09-12','2023-09-20',2,'600000', N'5000KM')
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF

Go
INSERT [dbo].[HoaDon]([MaHD],[MaKH],[MaNV],[NgayTao],[TrangThai],[TongTien])VALUES ('HD001', 1,'NV001', '2023-10-29',N'Đã thanh toán','21600000')
INSERT [dbo].[HoaDon]([MaHD],[MaKH],[MaNV],[NgayTao],[TrangThai],[TongTien])VALUES ('HD002', 2,'NV001', '2023-09-09',N'Chưa thanh toán','10800000')
INSERT [dbo].[HoaDon]([MaHD],[MaKH],[MaNV],[NgayTao],[TrangThai],[TongTien])VALUES ('HD003', 1,'NV002', '2023-09-09',N'Chưa thanh toán','10800000')



select * from NhanVien
select * from KhachHang
select * from ThongTinXe
select * from LoaiXe
select * from HoaDon
select * from HoaDonChiTiet


    -- Thống kê doanh thu trong năm
IF OBJECT_ID('Nam') IS NOT NULL
DROP PROCEDURE sp_ThongKeDoanhThuNam

CREATE PROCEDURE sp_ThongKeDoanhThuTheoThang
    @Thang INT,
    @Nam INT
AS
BEGIN
    DECLARE @TongDoanhThu DECIMAL(18, 2)
    DECLARE @DoanhThuThapNhat DECIMAL(18, 2)
    DECLARE @DoanhThuCaoNhat DECIMAL(18, 2)

    SELECT
        @TongDoanhThu = SUM(hd.TongTien),
        @DoanhThuThapNhat = MIN(hd.TongTien),
        @DoanhThuCaoNhat = MAX(hd.TongTien)
    FROM HoaDonChiTiet hdc
    JOIN HoaDon hd ON hdc.MaHD = hd.MaHD
    WHERE YEAR(hd.NgayTao) = @Nam
        AND MONTH(hd.NgayTao) = @Thang

    SELECT
        @Thang AS Thang,
        @Nam AS Nam,
        @TongDoanhThu AS TongDoanhThu,
        @DoanhThuThapNhat AS DoanhThuThapNhat,
        @DoanhThuCaoNhat AS DoanhThuCaoNhat;
END

--Doanh thu theo xe
CREATE PROCEDURE sp_DoanhThuXe 
    @maXe int, 
    @thang int, 
    @nam int
AS
BEGIN
    DECLARE @DoanhThu DECIMAL(18, 2);

    -- Tính toán doanh thu dựa trên thông tin của xe và các hóa đơn chi tiết
    SELECT @DoanhThu = SUM(hdct.GiaThue)
    FROM ThongTinXe ttx
    JOIN HoaDonChiTiet hdct ON ttx.MaXe = hdct.MaXe
    JOIN HoaDon hd ON hdct.MaHD = hd.MaHD
    WHERE ttx.MaXe = @maXe
        AND YEAR(hd.NgayTao) = @nam
        AND MONTH(hd.NgayTao) = @thang;

    -- Trả kết quả
    SELECT
		@maXe AS MaXe,
        @thang AS Thang,
        @nam AS Nam,
        @DoanhThu AS DoanhThu;
END;


--Doanh thu theo hóa đơn trong tháng, năm
CREATE PROCEDURE sp_ThongKeHoaDon
    @thang int,
    @nam int
AS
BEGIN
    -- Đặt ngày bắt đầu và kết thúc dựa trên tháng và năm đã cho
    DECLARE @NgayBatDau DATE, @NgayKetThuc DATE;

    SET @NgayBatDau = DATEFROMPARTS(@nam, @thang, 1);
    SET @NgayKetThuc = EOMONTH(@NgayBatDau);

    -- Thống kê số lượng hóa đơn trong tháng và năm
    DECLARE @SoLuongHoaDon INT;
    SELECT 
        @SoLuongHoaDon = COUNT(*)
    FROM 
        HoaDon HD
    WHERE 
        HD.NgayTao BETWEEN @NgayBatDau AND @NgayKetThuc;

    -- Thống kê doanh thu trong tháng và năm
    DECLARE @DoanhThu DECIMAL(18, 2);
    SELECT 
        @DoanhThu = SUM(HD.TongTien)
    FROM 
        HoaDon HD
    WHERE 
        HD.NgayTao BETWEEN @NgayBatDau AND @NgayKetThuc;

    -- Trả kết quả
    SELECT
        @thang AS Thang,
        @nam AS Nam,
        @SoLuongHoaDon AS SoLuongHoaDon,
        @DoanhThu AS DoanhThu;
END;




select * from NhanVien
select * from KhachHang
select * from HoaDon
select * from HoaDonChiTiet

