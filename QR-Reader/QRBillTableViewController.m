//
//  QRBillTableViewController.m
//  QR-Reader
//
//  Created by Sriram Vellangallor Subramanian on 1/23/16.
//  Copyright © 2016 Sriram Vellangallor Subramanian. All rights reserved.
//

#import "QRBillTableViewController.h"
#import "BillModel.h"

@interface QRBillTableViewController ()

@end

@implementation QRBillTableViewController
- (void)viewDidLoad {
    [super viewDidLoad];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    self.navigationItem.title=[NSString stringWithFormat:@"Bill #%d@%@ %@",(int)self.billNumber,self.storeName,self.strDate];
}


#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [self.arrBillModel count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleValue1 reuseIdentifier:@"Cell"];
    // Configure the cell...
    BillModel *objBillModel = [self.arrBillModel objectAtIndex:indexPath.row];
    [cell.textLabel setText:objBillModel.prodDescription];
    [cell.detailTextLabel setText:[NSString stringWithFormat:@"$%.02f",objBillModel.price]];
    
    return cell;
}

@end
