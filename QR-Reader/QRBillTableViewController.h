//
//  QRBillTableViewController.h
//  QR-Reader
//
//  Created by Sriram Vellangallor Subramanian on 1/23/16.
//  Copyright © 2016 Sriram Vellangallor Subramanian. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface QRBillTableViewController : UITableViewController

@property (nonatomic, weak) NSMutableArray* arrBillModel;
@property float billNumber;
@property (nonatomic, strong) NSString* storeName;
@property (nonatomic, strong) NSString* strDate;
@end
