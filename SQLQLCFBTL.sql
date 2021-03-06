USE [QLCF_BTL]
GO
/****** Object:  Table [dbo].[ban]    Script Date: 12/19/2019 9:21:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ban](
	[maban] [int] NOT NULL,
	[tenban] [nvarchar](50) NULL,
	[trangthai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maban] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[chitiethd]    Script Date: 12/19/2019 9:21:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chitiethd](
	[machitiethd] [int] IDENTITY(1,1) NOT NULL,
	[mahoadon] [int] NULL,
	[mamon] [int] NULL,
	[soluong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[machitiethd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hoadon]    Script Date: 12/19/2019 9:21:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoadon](
	[mahoadon] [int] IDENTITY(1,1) NOT NULL,
	[maban] [int] NULL,
	[trangthai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[mahoadon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[nhommon]    Script Date: 12/19/2019 9:21:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhommon](
	[maloai] [int] NOT NULL,
	[tenloai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[taikhoan]    Script Date: 12/19/2019 9:21:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[taikhoan](
	[id] [int] NOT NULL,
	[username] [varchar](40) NOT NULL,
	[password] [varchar](40) NOT NULL,
	[lv] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[thucdon]    Script Date: 12/19/2019 9:21:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thucdon](
	[mamon] [int] NOT NULL,
	[tenmon] [nvarchar](50) NULL,
	[dongia] [int] NULL,
	[DVT] [nvarchar](50) NULL,
	[maloai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[mamon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[chitiethd]  WITH CHECK ADD  CONSTRAINT [FK_3] FOREIGN KEY([mamon])
REFERENCES [dbo].[thucdon] ([mamon])
GO
ALTER TABLE [dbo].[chitiethd] CHECK CONSTRAINT [FK_3]
GO
ALTER TABLE [dbo].[chitiethd]  WITH CHECK ADD  CONSTRAINT [FK_4] FOREIGN KEY([mahoadon])
REFERENCES [dbo].[hoadon] ([mahoadon])
GO
ALTER TABLE [dbo].[chitiethd] CHECK CONSTRAINT [FK_4]
GO
ALTER TABLE [dbo].[hoadon]  WITH CHECK ADD  CONSTRAINT [FK_2] FOREIGN KEY([maban])
REFERENCES [dbo].[ban] ([maban])
GO
ALTER TABLE [dbo].[hoadon] CHECK CONSTRAINT [FK_2]
GO
ALTER TABLE [dbo].[thucdon]  WITH CHECK ADD FOREIGN KEY([maloai])
REFERENCES [dbo].[nhommon] ([maloai])
GO
