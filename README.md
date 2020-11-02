# lookcar

sql脚本

create user 'nt_first'@'%' identified by 'nt_first_113';

grant select ,insert,update,delete, drop on nt_first.* to "nt_first"@'%';
