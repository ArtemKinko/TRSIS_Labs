use stampsdb;
insert into stamp (stamp_name, stamp_year, price, image) VALUES
('Марка России №1', 1983, 23, 'https://rusmarka.ru/files/resize/Z60/300_300_0__files_sitedata_401_1439_3c8ec0a5-f343-4982-ae23-9ba367b93b51_jpg_800C54D5.jpg'),
('Марка России №2', 1989, 56, 'https://rusmarka.ru/files/resize/Z5D/300_300_0__files_sitedata_401_1439_22f58b6d-68b7-4682-806c-e61800ca8255_jpg_38C86806.jpg'),
('Будь героем!', 1968, 140, 'https://filtorg.ru/images/detailed/2/726.jpg');

insert into user (login, password) VALUES
('admin', '$2a$12$/YTkZNO0510.kYeSFqijVeOaaBTxjNaHZdAuo6Cu/H6fhgPufajbW'),
('user', '$2a$12$/mTmh.s4d1CmY5p1zjK50OZN25XklWkh738YXTlkbYDWTcrxg3SNe')